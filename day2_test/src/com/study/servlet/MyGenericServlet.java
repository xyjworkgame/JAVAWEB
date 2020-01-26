package com.study.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-04-22:33
 */

/**
 * 自定义一个Servlet 接口的实现类，让开发的任务Servlet 都继承该类
 * 以简化开发
 */
public abstract class MyGenericServlet implements Servlet ,ServletConfig{
   private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        init();
    }
    public void init()throws ServletException{

    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException ;


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
    /**
     * 以下方法为Servletconfig
     *接口的方法
     * @return
     */
    @Override
    public String getServletName() {
        return servletConfig.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    @Override
    public String getInitParameter(String s) {
        return servletConfig.getInitParameter(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return servletConfig.getInitParameterNames();
    }
}
