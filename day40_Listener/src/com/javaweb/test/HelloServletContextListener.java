package com.javaweb.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-28-19:51
 */
public class HelloServletContextListener implements ServletContextListener , ServletRequestListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 对象被创建" + servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("ServletContext 对象被销毁" + servletContextEvent.getServletContext());
    }


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.out.println("ServletRequest 被创建");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        System.out.println("ServletR 被销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        System.out.println("HttpSession 被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        System.out.println("HttpSession 被销毁");
    }
}
