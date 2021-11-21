package org.dyw.simple.framework.view.tag.extend;

import org.dyw.simple.framework.view.tag.DSimpleWatchTag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

//这是一个jsp标签
public class DSimpleScript extends DSimpleWatchTag {
    //多久后执行
    private String wait;

    @Override
    public String createContent() {
        String content="<script>"
                +"window.onload=function(){"
                +"setTimeout( function(){"
                +bodyContent.getString()
                +"}, "+wait+" );"
                +"};"
                +"</script>";
        return content;
    }
    public String getWait() {
        return wait;
    }
    public void setWait(String wait) {
        this.wait = wait;
    }
}
