package com.dyw.bean;

import org.dyw.simple.framework.ioc.annotation.DSimpleBean;
import org.dyw.simple.framework.ioc.annotation.DSimpleBeanType;
import org.dyw.simple.framework.orm.tool.DSimpleDatabase;
/**
 * @auther dyw
 * @vseion 1.0.0
 * 这是一个标准的DSimpleBean 主要用作业务逻辑的封装.
 * name是DSimpleBean的唯一标识，方便用户调用.
 * type是DSimpleBean的生命周期.
 * 理想的情况是，我们只在DSimpleBean中通过DSimpleDatabase使用ORM功能.
 * */
@DSimpleBean(name="userBean",type = DSimpleBeanType.Singleton)
public class UserBean {
    public String getPassword(String name){
        //这个方法通过name用SQL 后面可以无限跟参数
        String password=(String) DSimpleDatabase.using("userDao.getPassword",name);
        return password;
    }
}