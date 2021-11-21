package org.dyw.simple.framework.view.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public abstract class  DSimpleWatchTag extends BodyTagSupport {
    public abstract String createContent();
    //观察目标
    private String watch;
    //值
    private String value;
    @Override
    public int doEndTag() throws JspException {
        String name= (String) this.pageContext.getRequest().getAttribute(watch);
        if(name!=null&&name.equals(value)){
            //获取标签体内容对象
            BodyContent bodyContent = this.getBodyContent();
            JspWriter writer=this.pageContext.getOut();
            try {
                writer.println(createContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取PageContext对象
            //获取JspWriter对象
            //捕捉完毕后记得销毁
        }
        return super.doEndTag();
    }
    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
