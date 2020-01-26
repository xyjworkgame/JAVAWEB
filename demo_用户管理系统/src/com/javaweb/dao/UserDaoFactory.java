package com.javaweb.dao;

import com.javaweb.dao.impl.UserDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: UserDaoFactory
 * @Create : 2020/1/24
 * @Description :
 */
public class UserDaoFactory {
    private Map<String ,UserDao> daos = new HashMap<>();



    private  static UserDaoFactory instance = new UserDaoFactory();

    public static UserDaoFactory getInstance(){
        return instance;
    }

    public static String getType() {
        return type;
    }

    public UserDao getUserDao(){
        return daos.get(type);
    }

    private static String type = null;

    public UserDao getUserDAO(){
        return new UserDaoImpl();
    }

}
