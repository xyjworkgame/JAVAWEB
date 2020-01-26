package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-06-11:16
 */
@WebServlet(name = "RedirectServlet")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RedirectServlet's doGet");


        request.setAttribute("name","xyzmn");
        System.out.println("ForwardServlet's name" + request.getAttribute("name"));
        //执行请求的重定向，直接调用response。sendRedirect（path）方法
        //path为重定向的地址
        String path = "testServlet";
        response.sendRedirect(path);
    }
}
