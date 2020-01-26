package com.javaweb.service;

import com.javaweb.bean.User;
import com.javaweb.utils.AjaxResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: UserService
 * @Create : 2020/1/23
 * @Description :
 *  用户信息查询:
 *          1. 增加用户
 *          2. 删除用户
 *          3. 修改用户信息
 *          4. 查找用户信息
 */
public interface UserService {

    /**
     * 增加用户
     * @param user
     * @return
     */
    AjaxResult addUser(User user);

    /**
     * 删除用户id，但是这里是使用uid删除的
     * @param user
     * @return
     */
    AjaxResult deleteUser(User user);



    List<User> selectUser();

    /**
     * 修改用户信息 但不包括自己的用户信息
     * @param user
     * @return
     */
    AjaxResult putUser(User user);
}
