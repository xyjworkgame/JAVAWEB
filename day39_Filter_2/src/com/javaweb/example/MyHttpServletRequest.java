package com.javaweb.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-28-16:55
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper{


    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String val = super.getParameter(name);
        if (val != null && val.contains(" fuck ")){
            val = val.replace("fuck","****");

        }
        return val;
    }
}
