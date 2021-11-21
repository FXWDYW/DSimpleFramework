package org.dyw.simple.framework.mvc.controller;

import org.dyw.simple.framework.mvc.core.DSimple;
import org.dyw.simple.framework.view.page.DSimplePage;
import org.dyw.simple.framework.mvc.po.DSimpleInterfaceType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class DSimpleInterface extends HttpServlet {
    public DSimple simple=new DSimple();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setting();
        if(simple.setting.methods.get==false){
            //接管http
            simple.setHttp(req,resp);
            //绘制返回页
            simple.pen.write(DSimplePage.error);
            return;
        }
        this.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //加载配置
        setting();
        //接管http
        simple.setHttp(req,resp);
        //判断是否支持post方法
        if(simple.setting.methods.post==false){
            //绘制返回页面
            simple.pen.write(DSimplePage.error);
            return;
        }
        String value=execute();
        if(simple.setting.type== DSimpleInterfaceType.view)viewTypeReturn(value);
        else if(simple.setting.type== DSimpleInterfaceType.data)dataTypeReturn(value);
    }
    //返回数据
    private void dataTypeReturn(String value){
        if(value==null) {
            simple.pen.write(DSimplePage.error404);
            return;
        }
       simple.pen.write(value);
    }
    //返回视图
    private void viewTypeReturn(String value){
        if(value==null) return;
        String path=simple.urls.getPath(value);
        if(path==null) {
            simple.pen.write(DSimplePage.error404);
        }
        //跳转
        simple.jump(value);
    }

    protected abstract String execute();
    protected abstract void setting();
}
