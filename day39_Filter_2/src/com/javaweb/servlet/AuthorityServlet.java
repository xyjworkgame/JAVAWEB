package com.javaweb.servlet;

import com.javaweb.web.Authority;
import com.javaweb.web.User;
import com.javaweb.web.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-27-21:20
 */
public class AuthorityServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");


        try {
            Method method = getClass().getMethod(methodName,
                    HttpServletRequest.class,HttpServletResponse.class);

            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private UserDao userDao = new UserDao();
    public void  getAuthorities(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        User user = userDao.get(username);

        req.setAttribute("user",user);
        req.setAttribute("authorities",userDao.getAuthorities());
        req.getRequestDispatcher("/authority-manager.jsp").forward(req,resp);
    }

    public void updateAuthority(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String [] authorities = request.getParameterValues("authority");
        List<Authority> authorityList = userDao.getAuthorities(authorities);

        userDao.update(username, authorityList);
        response.sendRedirect(request.getContextPath() + "/authority-manager.jsp");
    }
}
