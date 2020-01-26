package com.token.tokenServlet;

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
 * @Create : 2018-10-18-14:37
 */
@WebServlet(name = "Servlet" ,urlPatterns = "/tokenServlet")
public class TokenServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//
//        HttpSession session = request.getSession();
//        Object token = session.getAttribute("token");
//        String tokenValue = request.getParameter("token");
//
//        System.out.println(token);
//        System.out.println(tokenValue);
//
//        if (token != null && token.equals(tokenValue)){
//            session.removeAttribute("token");
//        }else {
//            response.sendRedirect(request.getContextPath()+"/token/token.jsp");
//            return;
//        }
        boolean valid = TokenProcessor.getInstance().isTokenValid(request);

        if (valid){

            TokenProcessor.getInstance().resetToken(request);
        }else {
            response.sendRedirect(request.getContextPath()+"/token/token.jsp");
            return;
        }

        request.getRequestDispatcher("/token/sucess.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
