package test;

import com.study.mvcapp.Dao.CriteriaCustomer;
import com.study.mvcapp.Dao.CustomersDAO;
import com.study.mvcapp.Dao.impl.CustomerDAOjdbcImpl;
import com.study.mvcapp.domain.Customer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-12-14:16
 */
public class CustomerDAOjdbcImplTest {
    private CustomersDAO customersDAO =
            new CustomerDAOjdbcImpl();

    @Test
    public void testGetForListWithCriteriaCustomer(){
        CriteriaCustomer cc = new CriteriaCustomer("k",null,null);
        List<Customer> customers = customersDAO.getForListWithCriterIaCustomer(cc);
        System.out.println(customers);
    }
    @Test
    public void getAll() {
        List<Customer> customers = customersDAO.getAll();

        System.out.println(customers);

    }

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setAddress("shanghai ");
        customer.setName("jerry");
        customer.setPhone("122243532121");

        customersDAO.save(customer);
    }

    @Test
    public void get() {
        Customer customer = customersDAO.get(1);
        System.out.println(customer);
    }

    @Test
    public void delete() {

        customersDAO.delete(1);
    }

    @Test
    public void getCountWithName() {
        long count = customersDAO.getCountWithName("abc");
        System.out.println(count);
    }
}