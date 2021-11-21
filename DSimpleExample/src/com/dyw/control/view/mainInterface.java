package com.dyw.control.view;
import com.dyw.bean.UserBean;
import org.dyw.simple.framework.ioc.tool.DSimpleContext;
import org.dyw.simple.framework.mvc.controller.DSimpleInterface;
import org.dyw.simple.framework.mvc.po.DSimpleInterfaceType;

import javax.servlet.annotation.WebServlet;
/**
 * @author dyw
 * @version 1.0.0
 * 这属于DSimple框架的controller层的一种形式
 * 主要负责访问权限控制，配合动态页面生成技术.
 * */
@WebServlet(urlPatterns = "/main")
public class mainInterface extends DSimpleInterface {
    /**
     * 利用DSimpleContext获取相关的对象.
     * */
    UserBean userBean= (UserBean) DSimpleContext.getBean("userBean");
    /**
     * 在这里对DSimpleView进行配置
     * */
    @Override
    protected void setting() {
        //设置为视图模式
        simple.setting.type= DSimpleInterfaceType.view;
        //设置http的method
        simple.setting.methods.get=false;
        simple.setting.methods.post=true;
    }
    /**
     * 这里是具体的业务逻辑.
     * 所有的操作都封装到simple对象里面.便于用户理解.
     * 出口是路由.
     * */
    @Override
    protected String execute() {
        //监视表单是否有对应属性
        if(simple.filter.watch("name","password")){
            //获取数据库内部的相应密码
            String password=userBean.getPassword((String) simple.receive("name"));
            if(password!=null&&password.equals(simple.receive("password"))){
                //如果密码正确
                simple.send("name",simple.receive("name"));
                //跳转到main页面
                return "main";
            }
        }
        //发送消息1 msg=1
        simple.send("msg","1");
        //跳转到login页面
        return "login";
    }
}
