package com.javaweb.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-8:56
 */
public class HelloSimpleTag implements SimpleTag {


    private String value;
    private String count;

    public void setCount(String count) {
        this.count = count;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //标签体逻辑实际应该编写到方法中
    @Override
    public void doTag() throws JspException, IOException {

//        System.out.println("doTag");
//
//        System.out.println("value:"+ value +"  "+" count: "+count);
//        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//
//        pageContext.getOut().print("Hello:  "+ request.getParameter("name"));

        JspWriter out = pageContext.getOut();
        int c = 0;

        c = Integer.parseInt(count);
        for (int i = 0; i < c; i++) {
            out.print(value);
            out.print("<br>");
        }

    }

    @Override
    public void setParent(JspTag jspTag) {
        System.out.println("setParent");
    }

    @Override
    public JspTag getParent() {
        System.out.println("getParent");
        return null;
    }

    private PageContext pageContext;
    //jsp引擎调用，把代表jsp页面的PageContext对象传入
    // PageContext 可以获取jsp 页面的其他8个页面隐含对象
    //凡是jsp页面可以做的标签处理器都可以完成
    @Override
    public void setJspContext(JspContext jspContext) {

        System.out.println("setJspContext");

        this.pageContext = (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

        System.out.println("setJspBody");
    }
}
