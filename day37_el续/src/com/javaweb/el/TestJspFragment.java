package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-11:22
 */
public class TestJspFragment extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
       JspFragment bodyContent =  getJspBody();
       //JspFragment.invoke(witer) : Writer 即为标签体内容输出的字符流，若为null
        //输出到getJspContext().getOut(),即输出到页面

        //1.利用StringWriter 看到标签体的内容
        StringWriter sw = new StringWriter();
        bodyContent.invoke(sw);
        //2.把标签体的内容都变为大写

        String content = sw.toString().toUpperCase();
        //3.获取jsp页面的out隐含对象，输出到页面上
        getJspContext().getOut().print(content );
        System.out.println(sw.toString());
    }
}
