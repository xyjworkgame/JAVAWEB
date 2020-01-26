package com.javaweb.service.factory;


import com.javaweb.service.UserService;
import com.javaweb.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: UserServiceFactory
 * @Create : 2020/1/24
 * @Description :
 */
public class UserServiceFactory {

    private Map<String , UserService> daos = new HashMap<>();



    private  static UserServiceFactory instance = new UserServiceFactory();

    public static UserServiceFactory getInstance(){
        return instance;
    }

    public static String getType() {
        return type;
    }

    public UserService getuserService(){
        return daos.get(type);
    }

    private static String type = null;

    public UserService getUserService(){
        return new UserServiceImpl();
    }
}
