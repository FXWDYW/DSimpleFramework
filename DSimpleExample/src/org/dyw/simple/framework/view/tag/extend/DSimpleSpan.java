package org.dyw.simple.framework.view.tag.extend;

import org.dyw.simple.framework.view.tag.DSimpleWatchTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class DSimpleSpan extends DSimpleWatchTag {

    @Override
    public String createContent() {
        String content="<span>"
                +bodyContent.getString()
                +"</span>";
        return content;
    }
}
