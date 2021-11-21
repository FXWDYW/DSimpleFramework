package org.dyw.simple.framework.mvc.core;

import org.dyw.simple.framework.mvc.core.extend.DSimpleFilter;
import org.dyw.simple.framework.mvc.core.extend.DSimplePen;
import org.dyw.simple.framework.mvc.core.extend.DSimpleUrlsScan;
import org.dyw.simple.framework.mvc.po.DSimpleHttpSetting;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * DSimple类本质上是个request和response的管理工具
 * */
public class DSimple {
    /**
     * 网址集合
     * */
    public static DSimpleUrlsScan urls=new DSimpleUrlsScan();
    /**
     * 一些信息控制
     * */
    //方法
    public DSimpleHttpSetting setting= new DSimpleHttpSetting();
    /***
     * 构造方法
     */
    private HttpServletRequest request;
    private HttpServletResponse response;
    /**
     * 很多组件
     */
    //画笔
    public DSimplePen pen=new DSimplePen();
    //过滤器
    public DSimpleFilter filter=new DSimpleFilter();
    //设置连接
    public void setHttp( HttpServletRequest request,HttpServletResponse response){
        //设置编码
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //接管http
        this.request=request;
        this.response=response;
        this.pen.setHttp(request,response);
        this.filter.setHttp(request, response);
    }
    /**
     * 接收表单和属性配套使用
     * */
    public void send(String name,Object value){
        this.request.setAttribute(name,value);
    }
    public Object receive(String name){
       return this.request.getParameter(name);
    }
    /**
    * 页面跳转
    * */
    public void jump(String name){
        String path=urls.getPath(name);
        if(path==null) return;
        try {
            request.getRequestDispatcher(path).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//无状态
    public void call(String name){
        String path=urls.getPath(name);
        if(path==null) return;
        try {
            response.sendRedirect(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
