package com.study.mvcapp.Dao.factory;

import com.study.mvcapp.Dao.CustomersDAO;
import com.study.mvcapp.Dao.impl.CustomerDAOjdbcImpl;
import com.study.mvcapp.Dao.impl.CustomerDaoXMLImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-14-13:32
 */
public class CustomerDaofactory {

    private Map<String ,CustomersDAO> daos = new HashMap<String,CustomersDAO>();

    private CustomerDaofactory(){

        daos.put("jdbc",new CustomerDAOjdbcImpl());
        daos.put("xml",new CustomerDaoXMLImpl());
    }

    private  static CustomerDaofactory instance = new CustomerDaofactory();

    public static CustomerDaofactory getInstance(){
        return instance;
    }

    public static String getType() {
        return type;
    }

    public CustomersDAO getCustomerDao(){
        return daos.get(type);
    }

    private static String type = null;

    public CustomersDAO getCustomerDAO(){
        return new CustomerDAOjdbcImpl();
    }

}
