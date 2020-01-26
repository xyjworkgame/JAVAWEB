package com.javaweb.encoding;

import com.javaweb.Filter.HttpFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-25-21:04
 */
//@WebFilter(filterName = "EncodingFilter",urlPatterns = "/encoding/*")
public class EncodingFilter extends HttpFilter {


    private String encoding;


    protected void init() {
        encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
    }

    @Override
    public void doFilter(HttpServletRequest request,
                         HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println(encoding);
        request.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }
}
