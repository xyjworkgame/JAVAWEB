package com.javaweb.service;

import com.javaweb.bean.User;
import com.javaweb.utils.AjaxResult;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginService
 * @Create : 2020/1/23
 * @Description :
 *  admin 登录，忘记密码的一系列操作
 */
public interface LoginService {

    /**
     * 修改登录用户的信息，但不包括其他用户的信息
     * @param user
     * @return
     */
    AjaxResult putLogin(User user);

    User queryLogin(User user);
}
