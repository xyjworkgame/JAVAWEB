package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-21-14:52
 */
public class PrintUpperTag extends SimpleTagSupport {


    private String time;

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void doTag() throws JspException, IOException {

        //1.得到标签体的内容
        JspFragment bodyContent = getJspBody();
        StringWriter sw = new StringWriter();
        bodyContent.invoke(sw);
        String content = sw.toString();
        //2.变为大写
        content = content.toUpperCase();
        //3.得到out的隐含变量
        //4.循环输出
        int count =1;
        try {
            count = Integer.parseInt(time);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        for (int i = 0;i < count;i++){
            getJspContext().getOut().print(i+1  +"."+content+"<br>");
        }


    }
}
