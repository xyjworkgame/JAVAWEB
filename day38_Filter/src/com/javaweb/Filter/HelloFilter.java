package com.javaweb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-22-19:46
 */
//@WebFilter(filterName = "HelloFilter",urlPatterns = "/test.jsp")
public class HelloFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("destory");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("1.Before HelloFileter's doFilter...");

        //放行：
        chain.doFilter(req,resp);

        System.out.println("2.After HelloFilter's chain.doFilter");
    }
    //执行顺序是13542

    public void init(FilterConfig config) throws ServletException {

        System.out.println("init ...");
    }

}
