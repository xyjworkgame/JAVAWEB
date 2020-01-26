package com.javaweb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-23-16:32
 */
//@WebFilter(filterName = "PasswordFilter",urlPatterns = "/hello.jsp")
public class PasswordFilter implements Filter {
    private FilterConfig filterConfig;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String initpassword = filterConfig.getServletContext().getInitParameter("password");
        String password = req.getParameter("password");

        if (!initpassword.equals(password)){
            req.setAttribute("message","密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
