package com.javaweb.test; /**
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @version : 1.0
 * @Create : 2018-10-31-17:50
 */

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class TestAttributeListener implements ServletContextAttributeListener,
        ServletRequestListener, HttpSessionAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("向request中添加一个属性。。。");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("向request中移除一个属性");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("request 中属性替换了。。。");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
