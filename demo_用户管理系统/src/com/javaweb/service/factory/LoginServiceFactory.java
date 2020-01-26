package com.javaweb.service.factory;


import com.javaweb.service.LoginService;
import com.javaweb.service.impl.LoginServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginServiceFactory
 * @Create : 2020/1/24
 * @Description :
 */
public class LoginServiceFactory {

    private Map<String , LoginService> daos = new HashMap<>();



    private  static LoginServiceFactory instance = new LoginServiceFactory();

    public static LoginServiceFactory getInstance(){
        return instance;
    }

    public static String getType() {
        return type;
    }

    public LoginService getloginService(){
        return daos.get(type);
    }

    private static String type = null;

    public LoginService getLoginService(){
        return new LoginServiceImpl();
    }
}
