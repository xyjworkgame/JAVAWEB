package com.javaweb.dao;

import com.javaweb.bean.User;
import com.javaweb.utils.AjaxResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginDao
 * @Create : 2020/1/24
 * @Description :
 */
public interface UserDao {

    /**
     * 查找登录的用户信息
     * @param user
     * @return
     */
    User queryLogin(User user);

    /**
     * 只能单个修改数据
     * @param user
     * @return
     */
    AjaxResult putLogin(User user);

    AjaxResult addUser(User user);

    AjaxResult deleteUser(User user);

    List<User> selectUser();
}
