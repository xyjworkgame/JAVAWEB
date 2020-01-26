package com.javaweb.service;

import com.javaweb.bean.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2020-01-23-11:24
 * @Description :  <br/>
 */
public class Service {

    User user = new User("demo","123456");


    public int checkLoginService(String name,String pwd){

        if (user.getUsername() == name) {
            if (user.getPassword() == pwd) {
                    return  1;
            }else {
                return 0;
            }
        }else {
            return 2;
        }
    }
}
