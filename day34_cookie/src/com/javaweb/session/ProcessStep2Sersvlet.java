package com.javaweb.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-16-22:31
 */
@WebServlet(name = "processStep2" ,urlPatterns="/processStep2" )
public class ProcessStep2Sersvlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.获取请求参数：name , address, cardType, card
        String name = request.getParameter("name");
        String address = request.getParameter("addresss");
        String cartType = request.getParameter("cardType");
        String card = request.getParameter("card");
        Customer customer = new Customer(name,address,cartType,card);
        //2.把请求信息，存入到HttpSession 中
        HttpSession session = request.getSession();

        session.setAttribute("customer",customer);


        //3.重定向到confirm.jsp
        System.out.println(request.getContextPath() + "/shoppingcart/confirm.jsp");
        response.sendRedirect(request.getContextPath() + "/shoppingcart/confirm.jsp");

    }


}
