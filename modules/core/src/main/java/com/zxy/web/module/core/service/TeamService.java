package com.zxy.web.module.core.service;

import com.zxy.web.module.core.model.Team;
import com.zxy.web.module.core.orm.util.DynamicSpecifications;
import com.zxy.web.module.core.orm.util.SearchFilter;
import com.zxy.web.module.core.repository.jpa.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * TEAM DAO 对用户组进行管理操作
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class TeamService {

    private TeamDao teamDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Team team) {
        teamDao.save(team);
    }

    public Page<Team> getTeamByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                    String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Team> spec = buildSpecification(searchParams);
        return teamDao.findAll(spec, pageRequest);
    }

    private Specification<Team> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<Team> spec = DynamicSpecifications.bySearchFilter(filters.values(), Team.class);
        return spec;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "createDate");
        } else if ("teamName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "teamName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    public Team getTeam(String id) {
        return teamDao.findOne(id);
    }

    public TeamDao getTeamDao() {
        return teamDao;
    }

    @Autowired
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
}
