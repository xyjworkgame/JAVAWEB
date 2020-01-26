package com.javaweb.cache;

import com.javaweb.Filter.HttpFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerError;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-25-19:13
 */
@WebFilter(filterName = "NoCacheFilter",urlPatterns = "/cache/*")
public class NoCacheFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("cacheFilter's do");
        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");



            filterChain.doFilter(request,response);


    }
}
