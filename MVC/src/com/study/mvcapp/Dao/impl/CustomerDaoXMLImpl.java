package com.study.mvcapp.Dao.impl;

import com.study.mvcapp.Dao.CriteriaCustomer;
import com.study.mvcapp.Dao.CustomersDAO;
import com.study.mvcapp.domain.Customer;

import java.util.List;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: <br>
 * @Create : 2018-10-14-13:20
 */
public class CustomerDaoXMLImpl implements CustomersDAO {
    @Override
    public List<Customer> getForListWithCriterIaCustomer(CriteriaCustomer cc) {
        System.out.println("getForListWithCriterIaCustomer");
        return null;
    }

    @Override
    public List<Customer> getAll() {
        System.out.println(" getAll");
        return null;
    }

    @Override
    public void save(Customer customer) {

        System.out.println("save");
    }

    @Override
    public Customer get(Integer id) {
        System.out.println("get");
        return null;
    }

    @Override
    public void delete(Integer id) {
        System.out.println("delete");

    }

    @Override
    public void update(Customer customer) {

        System.out.println("update");
    }

    @Override
    public long getCountWithName(String name) {
        System.out.println("getCountWithName");
        return 0;
    }
}
