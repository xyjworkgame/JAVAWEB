package com.study.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-04-22:13
 */
public class loginServlet extends MyGenericServlet {

    /**
     *对当前的Servlet 进行初始化，覆盖init方法
     *
     */
    public void init() throws ServletException{
        System.out.println("初始化。。。");

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //获取请求方法是get还是post
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        System.out.println(httpServletRequest);


        //1.获取请求参数username，和password 提交过来的
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        //2.获取当前web应用的初始化参数user，和password

        //需要使用ServletContext 对象

        String initUser = getServletContext().getInitParameter("user");
        String initPassword = getServletContext().getInitParameter("password");


        PrintWriter out = servletResponse.getWriter();
        //3.比对
        //4.响应
            if (initUser.equals(username) && initPassword.equals(password)){
                out.print("hello " + username);
            }else {
                out.print("Sorry " + username);
            }

    }


}
