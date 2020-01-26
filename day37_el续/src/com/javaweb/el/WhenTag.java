package com.javaweb.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-21-20:31
 */
public class WhenTag extends SimpleTagSupport {

    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if(test){

            ChooseTag chooseTag = (ChooseTag) getParent();
            boolean flag = chooseTag.isFlag();

            if(flag){
                getJspBody().invoke(null);
                chooseTag.setFlag(false); //这个是让其他判断不在执行的条件
            }

        }
    }

}