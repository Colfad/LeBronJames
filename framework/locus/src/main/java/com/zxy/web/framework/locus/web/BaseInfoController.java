package com.zxy.web.framework.locus.web;

import com.google.common.collect.Maps;
import com.zxy.web.framework.locus.model.BaseInfo;
import com.zxy.web.framework.locus.service.BaseInfoService;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.web.Servlets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 角色Controller
 *
 * @author James
 */
@Controller
@RequestMapping("/baseInfo")
public class BaseInfoController {
    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private BaseInfoService baseInfoService;
    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("patientName", "患者姓名");
    }

    @RequestMapping("")
    public String toBaseInfoPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                 @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                                 @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                                 Model model, ServletRequest request) throws UnsupportedEncodingException {

        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<BaseInfo> baseInfos = baseInfoService.getBaseInfoByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("baseInfos", baseInfos);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        // 这里是为左侧的菜单激活的情况需要你自行进行修改的,菜单这里我们是不进行修改的操作
        model.addAttribute("baseInfoActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "baseInfo/baseInfoList";
    }

    @RequestMapping("delete/{id}")
    public String deleteBaseInfo(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        baseInfoService.deleteBaseInfo(id);
        redirectAttributes.addFlashAttribute("message", "Great.. 删除患者信息成功!");
        return "redirect:/baseInfo";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("baseInfo", new BaseInfo());
        model.addAttribute("action", "create");
        return "baseInfo/baseInfoForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid BaseInfo baseInfo, RedirectAttributes redirectAttributes, @RequestParam("id") String id) {
        System.out.println(id);
        FixEntityUtil.fixEntity(baseInfo);
        baseInfoService.saveBaseInfo(baseInfo);
        redirectAttributes.addFlashAttribute("message", "Great.. 创建患者信息成功!");
        return "redirect:/baseInfo";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("baseInfo", baseInfoService.getBaseInfo(id));
        model.addAttribute("action", "update");
        return "baseInfo/baseInfoForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("baseInfo") BaseInfo baseInfo, RedirectAttributes redirectAttributes) {
        baseInfoService.saveBaseInfo(baseInfo);
        redirectAttributes.addFlashAttribute("message", "Great.. 保存患者信息成功!");
        return "redirect:/baseInfo";
    }

    @ModelAttribute()
    public void getBaseInfo(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("baseInfo", baseInfoService.getBaseInfo(id));
        }
    }

    public BaseInfoService getBaseInfoService() {
        return baseInfoService;
    }

    @Autowired
    public void setBaseInfoService(BaseInfoService baseInfoService) {
        this.baseInfoService = baseInfoService;
    }
}