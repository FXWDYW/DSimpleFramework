package com.dyw.control.config;

import org.dyw.simple.framework.mvc.annotation.DSimpleUrl;
import org.dyw.simple.framework.mvc.annotation.DSimpleUrls;

/**
 * 这里类似于路由管理.
 * 对路径进行统一管理 避免前后端不分离项目开发中的路径变更问题.
 * 在view类型的control execute函数里面可以通过return "【name】"跳转
 * */
@DSimpleUrls({
        @DSimpleUrl(
                name = "login",
                path = "/WEB-INF/pages/login.jsp"),
        @DSimpleUrl(
                name = "main",
                path = "/WEB-INF/pages/main.jsp")
})

public interface Router { }
