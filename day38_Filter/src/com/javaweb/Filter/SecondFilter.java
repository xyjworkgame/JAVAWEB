package com.javaweb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-22-20:25
 */
//@WebFilter(filterName = "SecondFilter")
public class SecondFilter implements Filter {
    public void destroy() {

        System.out.println("seconddostroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("3.Before secondFileter's doFilter...");

        //放行：
        chain.doFilter(req,resp);

        System.out.println("4.After secondFilter's chain.doFilter");
    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("secondinit");
    }

}
