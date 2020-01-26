package com.javaweb.controller;

import com.alibaba.fastjson.JSON;
import com.javaweb.bean.User;
import com.javaweb.service.LoginService;
import com.javaweb.service.factory.LoginServiceFactory;
import com.javaweb.utils.AjaxResult;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginServlet
 * @Create : 2020/1/23
 * @Description : 登录
 */
public class LoginServlet extends HttpServlet {

    // 相当于自动spring 框架的自动装配
    private LoginService loginService = LoginServiceFactory.getInstance().getLoginService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        AjaxResult ajaxResult = new AjaxResult();
        resp.setContentType("application/json;charset=utf-8");
        String username = new String(req.getParameter("loginuser"));

        String password = req.getParameter("loginpwd");


        System.out.println(username + "---->" + password);
        User dbuser = loginService.queryLogin(new User(username,password));

        // HttpSession httpSession = null;


        //设置返回数据
        if (dbuser != null) {
            ajaxResult.setSuccess(true);
            req.setAttribute("loginUser",dbuser);
            // httpSession.setAttribute("loginUser",dbuser);
            ajaxResult.setData(dbuser);
            String jsonStr = JSON.toJSONString(ajaxResult);
            // System.out.println(jsonStr);
            resp.getWriter().write(jsonStr);
            System.out.println("账号密码成功");
        } else {
            System.out.println("账号密码错误");
            ajaxResult.setSuccess(false);
            String jsonStr = JSON.toJSONString(ajaxResult);
            // System.out.println(jsonStr);
            resp.getWriter().write(jsonStr);
        }


    }



}
