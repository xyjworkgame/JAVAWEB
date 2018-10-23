package com.javaweb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-23-16:25
 */
//@WebFilter(filterName = "UserNameFilter",urlPatterns = "/hello.jsp")
public class UserNameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String initUser = filterConfig.getInitParameter("username");
        String username = req.getParameter("username");

        if(!initUser.equals(username)){
            req.setAttribute("message", "用户名不正确");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        chain.doFilter(req, resp);
    }
    private FilterConfig filterConfig;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
