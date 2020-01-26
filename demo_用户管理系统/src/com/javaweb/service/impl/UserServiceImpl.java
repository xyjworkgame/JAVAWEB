package com.javaweb.service.impl;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import com.javaweb.dao.UserDaoFactory;
import com.javaweb.service.UserService;
import com.javaweb.utils.AjaxResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: UserServiceImpl
 * @Create : 2020/1/23
 * @Description :
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = UserDaoFactory.getInstance().getUserDAO();

    @Override
    public AjaxResult addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public AjaxResult deleteUser(User user)
    {
        return userDao.deleteUser(user);
    }

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public AjaxResult putUser(User user) {
        return null;
    }
}
