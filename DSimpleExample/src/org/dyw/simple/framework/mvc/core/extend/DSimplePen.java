package org.dyw.simple.framework.mvc.core.extend;

import org.dyw.simple.framework.mvc.core.DSimpleControllerTool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 用来写HTML的画笔
 * */
public class DSimplePen extends DSimpleControllerTool {
    public void write(String content){
        try {
            this.response.getWriter().print(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
