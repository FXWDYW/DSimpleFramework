package com.dyw.control.view;

import org.dyw.simple.framework.mvc.controller.DSimpleInterface;
import org.dyw.simple.framework.mvc.po.DSimpleInterfaceType;

import javax.servlet.annotation.WebServlet;
/**
 * 把jsp页面放在WEB-INF目录 防止外部访问
 * */
@WebServlet(urlPatterns = "/login")
public class loginInterface extends DSimpleInterface {
    @Override
    protected void setting() {
        //设置为视图模式
        simple.setting.type= DSimpleInterfaceType.view;
        //设置http的method
        simple.setting.methods.get=true;
    }
    @Override
    protected String execute() {
        // 跳转到login页面 login指向的网址配置样例在control.config里面
        return "login";
    }
}
