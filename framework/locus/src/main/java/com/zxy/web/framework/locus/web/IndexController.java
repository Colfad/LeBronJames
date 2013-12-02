package com.zxy.web.framework.locus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页的Controller类
 *
 * @author James
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public ModelAndView toIndex() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("indexActive", "active");

        return view;
    }

    @RequestMapping("toFileUpload")
    public String toFileUploadPage() {
        return "/admin/fileUpload";
    }

}
