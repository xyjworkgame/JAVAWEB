package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-16:03
 */
public class SonTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {

        //1.得到父标签的引用
        JspTag parent = getParent();
        //2.获取父标签的name属性
        ParentTag parentTag = (ParentTag) parent;
        String name = parentTag.getName();
        //3.把name值打印到JSP页面上

        getJspContext().getOut().print("子标签输出name："+name);
    }
}
