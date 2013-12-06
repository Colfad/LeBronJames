package com.zxy.web.module.core.web;

import com.google.common.collect.Maps;
import com.zxy.web.module.core.model.Team;
import com.zxy.web.module.core.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * Team Controller 操作类
 *
 * @author James
 */
@Controller
@RequestMapping("/account/team")
public class TeamController {

    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
    private TeamService teamService;

    public TeamService getTeamService() {
        return teamService;
    }

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("teamName", "用户组名");
    }


    @RequestMapping("toTeamPage")
    public String toTeamPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                             @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                             @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                             Model model, ServletRequest request) {

        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<Team> teams = teamService.getTeamByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("teams", teams);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("teamActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "account/teamList";
    }


}
