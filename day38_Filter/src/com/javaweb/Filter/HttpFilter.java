package com.javaweb.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-23-22:34
 */
//@WebFilter(filterName = "HttpFilter"

/**
 * 自定义的HttpFilter ，实现自Filter接口
 *
 */
public abstract class HttpFilter implements Filter {
    /**
     * 空的destroy方法。
     */
    public void destroy() {
    }

    /**
     * 原生的doFilter 方法，在方法内容把ServletRequest 和 ServletResponse
     * 转为了HttpServletRequest 和HttpServletResource 并调用了
     *doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
     *
     * 若别写了Filter的过滤不建议直接继承该方法，而建议继承
     * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        doFilter(req,resp,chain);
    }

    /**
     * 用于保存FilterCOnfig对象
     */
    private FilterConfig filterConfig;

    /**
     * 抽象方法，为http请求定制，必须实现的方法
     * @param request
     * @param response
     * @param filterChain
     */
    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain);

    /**
     * 不建议子类直接覆盖，如直接覆盖，有可能会导致filtereConfig成员初始化失败
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        init();
    }

    /**
     * 供子类继承的初始化方法，可以通过getFilterConfig 获取FilterConfig对象
     */
    private void init() {
    }

    /**
     * 直接返回init（SErsvletConfig）返回FilterConfig对象
     * @return
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }
}
