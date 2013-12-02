package com.zxy.web.framework.locus.servlet;

import com.zxy.web.framework.locus.file.core.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class FileInitServlet extends HttpServlet {

    public FileInitServlet() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {

        // 当这个Servlet启动的时候会将配置文件中的信息给加载出来
        Config.loadProperties();
    }
}
