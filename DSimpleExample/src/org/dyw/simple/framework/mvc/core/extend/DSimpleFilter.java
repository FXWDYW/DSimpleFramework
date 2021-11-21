package org.dyw.simple.framework.mvc.core.extend;

import org.dyw.simple.framework.mvc.core.DSimpleControllerTool;

public class DSimpleFilter extends DSimpleControllerTool {
    /**
     * 观察表单里是否有属性.
     * */
    public boolean watch(String...names){
        for(String name:names){
            if(this.request.getParameter(name)==null)return false;
            System.out.println("DSimple->MVC->->Filter->Watch->"+name);
        }
        return true;
    }
}
