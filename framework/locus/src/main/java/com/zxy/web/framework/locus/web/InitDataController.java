package com.zxy.web.framework.locus.web;

import com.zxy.web.framework.locus.model.User;
import com.zxy.web.framework.locus.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/init")
public class InitDataController {
    private AccountService accountService;

    @RequestMapping("userData")
    public String initUserData() {

        User user = new User();
        user.setPlainPassword("admin@xz");
        user.setUserName("admin");
        user.setEmail("zhouxy.vortex@gmail.com");

        accountService.saveUser(user);

        return "index";
    }

    public AccountService getAccountService() {
        return accountService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
