package com.zxy.web.framework.locus.web;


import com.google.common.collect.Maps;
import com.zxy.web.framework.locus.model.MenuTree;
import com.zxy.web.framework.locus.service.MenuTreeService;
import com.zxy.web.framework.locus.service.TableService;
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
import java.util.Map;

/**
 * Menu的Controller
 *
 * @author James
 */
@Controller
@RequestMapping("/menu")
public class MenuTreeController {

    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("menuName", "菜单名称");
    }

    private MenuTreeService menuTreeService;
    private TableService tableEntityService;

    @RequestMapping("")
    public String toMenuTreePage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                 @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                                 @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                                 Model model, ServletRequest request) {
        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<MenuTree> menus = menuTreeService.getMenuTreeByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("menus", menus);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("menuActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "menu/menuList";

    }

    @RequestMapping("delete/{id}")
    public String deleteMenuTree(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        menuTreeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Great.. 删除权限成功!");
        return "redirect:/menu";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("menu", new MenuTree());
        model.addAttribute("action", "create");
        model.addAttribute("tableVars", tableEntityService.findAllTableEntity());
        return "menu/menuForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid MenuTree menuTree, RedirectAttributes redirectAttributes, @RequestParam("tableId") String tableId) {
        FixEntityUtil.fixEntity(menuTree);
        String url = "/other/" + tableId;
        menuTree.setUrl(url);
        menuTreeService.saveMenuTree(menuTree);
        redirectAttributes.addFlashAttribute("message", "Great.. 创建权限成功!");
        return "redirect:/menu";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("menu", menuTreeService.getMenuTree(id));
        model.addAttribute("action", "update");
        model.addAttribute("menuActive", "active");
        model.addAttribute("tableVars", tableEntityService.findAllTableEntity());
        return "menu/menuForm";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("menu") MenuTree menuTree, RedirectAttributes redirectAttributes, @RequestParam(value = "tableId", required = false) String tableId) {
        if (tableId != null && !"".equals(tableId.trim())) {
            menuTree.setUrl("/other/" + tableId);
        }
        menuTreeService.saveMenuTree(menuTree);
        redirectAttributes.addFlashAttribute("message", "Great.. 保存权限成功!");
        return "redirect:/menu";
    }

    @ModelAttribute()
    public void getMenu(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("menu", menuTreeService.getMenuTree(id));
        }
    }

    public MenuTreeService getMenuTreeService() {
        return menuTreeService;
    }

    @Autowired
    public void setMenuTreeService(MenuTreeService menuTreeService) {
        this.menuTreeService = menuTreeService;
    }

    public TableService getTableEntityService() {
        return tableEntityService;
    }

    @Autowired
    public void setTableEntityService(TableService tableEntityService) {
        this.tableEntityService = tableEntityService;
    }
}
