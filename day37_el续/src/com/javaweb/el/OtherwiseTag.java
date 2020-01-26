package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-20:36
 */
public class OtherwiseTag  extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException, IOException {
        ChooseTag chooseTag = (ChooseTag) getParent();

        if(chooseTag.isFlag()){
            getJspBody().invoke(null);
        }
    }
}
