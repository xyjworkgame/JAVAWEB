package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-06-10:27
 */
public class testAttr  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //1.在servlet 中无法得到pageContext对象
        //2.request
        Object requestAttr = req.getAttribute("requestAttr");
        out.print("requestAttr   " + requestAttr);
        out.print("<br><br>");

        //3.session
        Object sessionAttr = req.getSession().getAttribute("sessionAttr");
        out.print("sessionAttr  " + sessionAttr);
        out.print("<br><br>");
        //4.application

        Object applicationAttr = getServletContext().getAttribute("applicationAttr");
        out.print("applicationAttr  " + applicationAttr);
        out.print("<br><br>");






    }
}
