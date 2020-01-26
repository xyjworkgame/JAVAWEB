package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.net.SocketImpl;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-20:37
 */
public class ChooseTag  extends SimpleTagSupport {


    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(null);
    }
}
