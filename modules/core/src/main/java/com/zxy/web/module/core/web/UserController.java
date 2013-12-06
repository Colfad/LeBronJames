package com.zxy.web.module.core.web;

import com.google.common.collect.Maps;
import com.zxy.web.module.core.model.User;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.service.AccountService;
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
 * 用户管理界面
 *
 * @author James
 */
@Controller
@RequestMapping("/account/user")
public class UserController {
    private static final String PAGE_SIZE = "15";
    private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

    private AccountService accountService;

    static {
        sortTypes.put("auto", "自动");
    }

    @RequestMapping("")
    public String toUserPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                      @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                      @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                      Model model, ServletRequest request) {
        Map<String, Object> searchParam = Servlets.getParametersStartingWith(request, "search_");

        Page<User> users = accountService.getUserByPage(searchParam, pageNumber, pageSize, sortType);

        model.addAttribute("users", users);
        model.addAttribute("sortType", sortType);
        model.addAttribute("sortTypes", sortTypes);
        model.addAttribute("userActive", "active");

        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParam, "search_"));

        return "account/userList";
    }

    @RequestMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        accountService.deleteUser(id);
        redirectAttributes.addFlashAttribute("message", "Great ... 删除用户成功!!!");
        return "redirect:/account/userList";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("action", "create");
        return "account/userForm";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", accountService.getUserById(id));
        model.addAttribute("action", "update");
        model.addAttribute("userActive", "active");
        return "account/userForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid User user, RedirectAttributes redirectAttributes) {
        FixEntityUtil.fixEntity(user);
        accountService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Great ... 创建用户成功!!!");
        return "redirect:/account/userList";
    }

    @ModelAttribute()
    public void getUser(@RequestParam(value = "id", required = false) String id, Model model) {
        if (id != null && !id.trim().equals("")) {
            model.addAttribute("user", accountService.getUserById(id));
        }
    }

    public AccountService getAccountService() {
        return accountService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
