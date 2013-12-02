package com.zxy.web.framework.locus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 商品管理的Controller
 *
 * @author James
 */
@Controller
@RequestMapping("/admin/good")
public class GoodController {

    @RequestMapping("")
    public ModelAndView toPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/good/goodManage");
        modelAndView.addObject("goodManage", "active");
        return modelAndView;
    }
}
