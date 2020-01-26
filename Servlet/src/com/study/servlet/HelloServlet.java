package com.study.servlet;

import jdk.internal.util.xml.impl.Input;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-03-21:46
 */
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");


        String user = servletConfig.getInitParameter("user");
        System.out.println(user);

        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);

            System.out.println("^^"+name+" :" + value);
        }

        String servletname = servletConfig.getServletName();
        System.out.println(servletname);


        //获取SErvletCOntext对象
        ServletContext servletContext = servletConfig.getServletContext();

        String driver = servletContext.getInitParameter("driver");
        System.out.println("dirver:" +driver);

        Enumeration<String> names2 = servletContext.getInitParameterNames();
        while (names2.hasMoreElements()){
            String name = names2.nextElement();
            System.out.println("-->" + name);
        }

        String realPath = servletContext.getRealPath("/demo.txt");
        System.out.println(realPath);

        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        try{

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
            System.out.println("1. " + is);

        }catch (Exception e){
            e.printStackTrace();
        }


        try {
            InputStream is2 = servletContext.getResourceAsStream("\\WEB-INF\\classes\\jdbc.properties");
            System.out.println("2.  "+ is2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");

    }
}
