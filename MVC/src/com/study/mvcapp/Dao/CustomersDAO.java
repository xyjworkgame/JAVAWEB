package com.study.mvcapp.Dao;

import com.study.mvcapp.domain.Customer;

import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-22:28
 */
public interface CustomersDAO {

    /**
     * 返回满足查询条件的list
     * @param cc 封装了查询条件
     * @return
     */
    public  List<Customer> getForListWithCriterIaCustomer(CriteriaCustomer cc);
    public List<Customer> getAll();

    public void save(Customer customer);

    public Customer get(Integer id);

    public void delete(Integer id  );

    public void  update(Customer customer);

    /**
     * 返回和name相等的记录数
     * @param name
     * @return
     */
    public long getCountWithName(String name);

}
