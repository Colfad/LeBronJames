package com.zxy.web.module.core.web;

import com.google.common.collect.Maps;
import com.zxy.web.module.core.model.Role;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 角色Controller
 *
 * @author James
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private static final String PAGE_SIZE = "5";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private RoleService roleService;
    static {
        sortTypes.put("auto", "自动");
        sortTypes.put("roleName", "权限名称");
    }

    @RequestMapping("")
    public String toRolePage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                   @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                                   @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                                   Model model, ServletRequest request) throws UnsupportedEncodingException {

        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");
        Page<Role> roles = roleService.getRoleByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("roles", roles);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("roleActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "role/roleList";
    }

    @RequestMapping("delete/{id}")
    public String deleteRole(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        roleService.deleteRole(id);
        redirectAttributes.addFlashAttribute("message", "Great.. 删除权限成功!");
        return "redirect:/role";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("action", "create");
        model.addAttribute("roleActive", "active");
        return "role/roleForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid Role role, RedirectAttributes redirectAttributes, @RequestParam("id") String id) {
        System.out.println(id);
        FixEntityUtil.fixEntity(role);
        roleService.saveRole(role);
        redirectAttributes.addFlashAttribute("message", "Great.. 创建权限成功!");
        return "redirect:/role";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("role", roleService.getRole(id));
        model.addAttribute("action", "update");
        model.addAttribute("roleActive", "active");
        return "role/roleForm";
    }

    @RequestMapping(value = "setPermission/{id}", method = RequestMethod.GET)
    public String permissionForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("role", roleService.getRole(id));
        model.addAttribute("action", "setPermission");
        model.addAttribute("roleActive", "active");
        return "role/rolePermissionForm";
    }


    @RequestMapping(value = "setPermission", method = RequestMethod.POST)
    public String permission(@Valid @ModelAttribute("role") Role role, RedirectAttributes redirectAttributes) {
        List<String> list = role.getPermissionList();
        String nowPermissionString = role.getPermissions();
        StringBuffer sb = new StringBuffer("");
        boolean permissionOne = false;
        boolean permissionTwo = false;
        boolean permissionThree = false;
        boolean permissionFour = false;
        for (String temp : list) {
            if (temp.indexOf("artery") != -1 || temp.indexOf("cerebral") != -1 || temp.indexOf("bloodvessel") != -1) {
                if (permissionOne) {
                    continue;
                }
                sb.append(",mind:view");
                permissionOne = true;
                continue;
            }
            if (temp.indexOf("aorta") != -1 || temp.indexOf("kidney") != -1 || temp.indexOf("arms") != -1) {
                if (permissionTwo) {
                    continue;
                }
                sb.append(",cube:view");
                permissionTwo = true;
                continue;
            }
            if (temp.indexOf("cancer") != -1 || temp.indexOf("icterus") != -1 || temp.indexOf("alimentary") != -1) {
                if (permissionThree) {
                    continue;
                }
                sb.append(",all:view");
                permissionThree = true;
                continue;
            }
            if (temp.indexOf("user") != -1 || temp.indexOf("team") != -1 || temp.indexOf("role") != -1) {
                if (permissionFour) {
                    continue;
                }
                sb.append(",system:view");
                permissionFour = true;
                continue;
            }

        }

        nowPermissionString = nowPermissionString + sb.toString();
        role.setPermissions(nowPermissionString);

        roleService.saveRole(role);
        redirectAttributes.addFlashAttribute("message", "Great.. 修改权限值成功!");
        return "redirect:/role";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("role") Role role, RedirectAttributes redirectAttributes) {
        roleService.saveRole(role);
        redirectAttributes.addFlashAttribute("message", "Great.. 保存权限成功!");
        return "redirect:/role";
    }

    @RequestMapping(value = "findAllRole", method = RequestMethod.POST)
    public @ResponseBody List<Role> findAllRole() {
        List<Role> roles = roleService.getAllRole();
        return roles;
    }

    @RequestMapping(value = "toJqPage", method = RequestMethod.GET)
    public String jqGridPage(Model model) {
        model.addAttribute("roleActive", "active");
        return "role/roleJqList";
    }

    @ModelAttribute()
    public void getRole(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("role", roleService.getRole(id));
        }
    }

    public RoleService getRoleService() {
        return roleService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}