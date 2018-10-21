package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-21-16:01
 */
public class ParentTag extends SimpleTagSupport {

    private String name = "AT";

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("父标签处理器的name :" +name);
        getJspBody().invoke(null);

    }
}
