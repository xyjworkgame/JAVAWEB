package com.javaweb.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-9:43
 */
public class MaxTag implements SimpleTag {

    private String num1;
    private String num2;

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    @Override
    public void doTag() throws JspException, IOException {

        int a = 0;
        int b = 0;

        JspWriter out = pageContext.getOut();
        try {

            a = Integer.parseInt(num1);
            b = Integer.parseInt(num2);
            out.print(a>b? a:b);
        }catch (Exception e){
            System.out.println("格式不正确");
        }
    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    private PageContext pageContext;
    @Override
    public void setJspContext(JspContext jspContext) {
        this.pageContext = (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}
