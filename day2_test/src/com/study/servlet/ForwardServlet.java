package com.study.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-06-11:03
 */
public class ForwardServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ForwardServlet's doGet");

        req.setAttribute("name","xyzmn");
        System.out.println("ForwardServlet's name" + req.getAttribute("name"));
        //请求的转发
        //1.调用HttpSErvletRequest 的GetRequestDispatcher 方法获取RequestDIspatcher 对象
        //调用agetRequestDispatcher 需要传入要转发的地址
        String path = "testServlet";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/"+path);


        //2调用HTTPServletRequest 的forward （request，response ） 进行请求的转发
        requestDispatcher.forward(req,resp);
    }
}
