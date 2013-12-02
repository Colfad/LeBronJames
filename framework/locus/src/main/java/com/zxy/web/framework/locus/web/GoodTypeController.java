package com.zxy.web.framework.locus.web;

import com.zxy.web.framework.locus.service.GoodTypeMyBatisService;
import com.zxy.web.module.core.bean.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 货物的类型的Controller对象
 *
 * @author James
 */
@Controller
@RequestMapping("/admin/goodType")
public class GoodTypeController {

    private GoodTypeMyBatisService goodTypeMyBatisService;

    @RequestMapping("")
    public ModelAndView toPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/good/goodType");
        modelAndView.addObject("goodType", "active");
        return modelAndView;
    }

    /**
     *
     * 这里进行树的加载应该是一层一层的往下进行加载的操作
     *
     * @param id
     * @return
     */
    @RequestMapping("/loadTree/{id}")
    public @ResponseBody ResponseEntity<Tree> loadTree(@PathVariable("id") String id) {
        //加载TREE或者是根据ID懒加载TREE
        Tree tree = null;
        if (id != null) {
            tree = goodTypeMyBatisService.getGoodTypeTree("1");
        } else {
            tree = goodTypeMyBatisService.getGoodTypeTree(id);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        ResponseEntity<Tree> entity = new ResponseEntity<Tree>(tree, headers, HttpStatus.OK);
        return entity;
    }

    public GoodTypeMyBatisService getGoodTypeMyBatisService() {
        return goodTypeMyBatisService;
    }

    @Autowired
    public void setGoodTypeMyBatisService(GoodTypeMyBatisService goodTypeMyBatisService) {
        this.goodTypeMyBatisService = goodTypeMyBatisService;
    }
}
