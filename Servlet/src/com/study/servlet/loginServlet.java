package com.study.servlet;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-04-14:27
 */
public class loginServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("sucess?");
        System.out.println(servletRequest);

        String user  = servletRequest.getParameter("user");
        String password = servletRequest.getParameter("password");

        System.out.println(user + "," + password);


        String interesting = servletRequest.getParameter("interesting");
        System.out.println(interesting);

        String[] interestings = servletRequest.getParameterValues("interesting");
        for (String interest : interestings){
            System.out.println("-->" + interest);
        }


        Enumeration<String> names = servletRequest.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String val = servletRequest.getParameter(name);

            System.out.println(name + ", " + val);

        }
        Map<String,String[]> map = servletRequest.getParameterMap();
        for (Map.Entry<String,String[]> entry : map.entrySet()){
            System.out.println("**"+entry.getKey() + " : " + Arrays.asList(entry.getValue()));

        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String requestUrl = httpServletRequest.getRequestURI();
        System.out.println(requestUrl);


        String method = httpServletRequest.getMethod();
        System.out.println(method);

        String queryString = httpServletRequest.getQueryString();
        System.out.println(queryString);

        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath);


        servletResponse.setContentType("application/msword");

        PrintWriter out = servletResponse.getWriter();
        out.print("helloworld...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
