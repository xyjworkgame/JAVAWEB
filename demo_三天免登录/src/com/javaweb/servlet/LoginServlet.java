package com.javaweb.servlet;

import com.javaweb.bean.User;
import com.javaweb.service.Service;
import sun.net.www.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2020-01-23-11:12
 * @Description :  <br/>
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Service service = new Service();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + "--->" + password);


        int code = service.checkLoginService(username, password);

        User user = new User(username,password);
        req.setAttribute("code", code);
        if (code == 1) {

            // 添加cookie 信息
            Cookie cookie = new Cookie("uid",user);

        }
    }


}
