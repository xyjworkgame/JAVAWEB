package com.javaweb.service.impl;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import com.javaweb.dao.UserDaoFactory;
import com.javaweb.service.LoginService;
import com.javaweb.utils.AjaxResult;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginServiceImpl
 * @Create : 2020/1/23
 * @Description :
 */
public class LoginServiceImpl implements LoginService {


    private UserDao userDao = UserDaoFactory.getInstance().getUserDAO();



    @Override
    public AjaxResult putLogin(User user) {

        return userDao.putLogin(user);
    }

    @Override
    public User queryLogin(User user) {


        // System.out.println(user.toString()  +" service 类");
        return userDao.queryLogin(user);
    }
}
