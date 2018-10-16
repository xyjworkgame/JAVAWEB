package com.javaweb.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-16-19:12
 */
@WebServlet(name = "ProcessStep1Servlet" , urlPatterns = "/processStep1")
public class ProcessStep1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.或许选中的图书信息
        String [] books = request.getParameterValues("book");
        //2.把图书信息放入到Httpsession 中
        request.getSession().setAttribute("books",books);
        //2.重定向页面到shoppingcart/step-1.jsp

        System.out.println(request.getContextPath() + "/shoppingcart/step-2.jsp");
        response.sendRedirect(request.getContextPath() + "/shoppingcart/step-2.jsp");//绝对路径

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
