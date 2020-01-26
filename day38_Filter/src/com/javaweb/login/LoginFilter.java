package com.javaweb.login;

import com.javaweb.Filter.HttpFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-25-21:42
 */

public class LoginFilter extends HttpFilter {

    //1.获取SessionKey，redirekey，redirectURL，uncheckedUrls
    private String sessionKey;
    private String redirectUrl;
    private String unchekcedUrl;

    @Override
    protected void init() {
        ServletContext servletContext = getFilterConfig().getServletContext();

        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectUrl = servletContext.getInitParameter("rediretPage");
        unchekcedUrl = servletContext.getInitParameter("uncheckedUrls");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {


        //1.获取请求的URL

        ///login/dologin.jsp/login/a.jsp,/login/list.jsp,/login/login.jsp,/login/doLogin.jsp,/login/b.jsp
        String servletpath = request.getServletPath();


        //2.检查1获取的servletPath 是否为不需要检查的URL中的一个，若是，则直接放行，方法结束
        List<String> urls = Arrays.asList(unchekcedUrl.split(","));
        if (urls.contains(servletpath)){
            filterChain.doFilter(request,response);
            return;
        }
        // 3.从session 中获取sessionkey对应的值 ，若他不存在，则重定向到redirectUrl
        Object user = request.getSession().getAttribute(sessionKey);
        if (user == null){
            response.sendRedirect(request.getContextPath()+redirectUrl);
            return;
        }
        // 4.若存在，则放行，容许访问
        filterChain.doFilter(request,response);
        // 5.
    }
}
