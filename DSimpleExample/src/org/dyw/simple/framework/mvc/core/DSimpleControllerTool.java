package org.dyw.simple.framework.mvc.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class DSimpleControllerTool {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    public void setHttp(HttpServletRequest request,HttpServletResponse response){
        this.request=request;
        this.response=response;
    }
}
