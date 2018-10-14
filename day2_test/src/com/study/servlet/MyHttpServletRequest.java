package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-05-9:45
 */
/**
 * 针对于HTTP 协议定义的一个SErvlet 基类
 */
public class MyHttpServletRequest extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;


            if (servletResponse instanceof HttpServletResponse) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;

                service(request,response);
            }
        }
    }

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //1.获取请求方式
        String method = httpServletRequest.getMethod();
        //2.根据请求方式再调用对应的处理方法

        if ("GET".equalsIgnoreCase(method)){
            doGet(httpServletRequest,httpServletResponse);
        }else if ("POST".equalsIgnoreCase(method)){
            doPost(httpServletRequest,httpServletResponse);
        }
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    }
}
