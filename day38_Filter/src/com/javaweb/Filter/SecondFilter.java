package com.javaweb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-22-20:25
 */
//@WebFilter(filterName = "SecondFilter")
public class SecondFilter implements Filter {
    public void destroy() {

        System.out.println("seconddostroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("seconddoFilter");

        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("secondinit");
    }

}
