package com.Servelt.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-11:51
 */

public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String flowID = request.getParameter("flowId");

        studentDao studentDao = new studentDao();

        studentDao.deleteByFlowId(Integer.parseInt(flowID));


        request.getRequestDispatcher("/sucess.jsp").forward(request,response);


    }
}
