package com.study.mvcapp.servlet;

import com.study.mvcapp.Dao.CriteriaCustomer;
import com.study.mvcapp.Dao.CustomersDAO;
import com.study.mvcapp.Dao.impl.CustomerDAOjdbcImpl;
import com.study.mvcapp.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-12-16:01
 */
@WebServlet(name = "customerServlet", urlPatterns = "*.do")
public class CustomerServlet extends HttpServlet {

    private CustomersDAO customersDAO = new CustomerDAOjdbcImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }


//


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取serveltpath :获取文件题目
        String servletPath = req.getServletPath();
        //2.修改获取的信息
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0,methodName.length() -3);


        try {
            //3，利用反射获取methodName 对应的方法
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            //4.利用反射调用对应的方法
            method.invoke(this,req,resp);
        } catch (Exception e){
            //可以有一些相应
            //e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {

        String forwardPath = null;
        //1.获取请求参数id
        String idStr = req.getParameter("id");
        int id = -1;

        //2,嗲用CustomerDao 的customerDao。getid 的和对象
        try {
            Customer customer = customersDAO.get(Integer.parseInt(idStr));

            if (customer != null){
                forwardPath ="/updatecustomer.jsp";

                //3.将customer放入request中
                req.setAttribute("customer",customer);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        //4.响应updatecustomer。jsp对象
        req.getRequestDispatcher(forwardPath).forward(req,resp);
        //要进行回显，结束方法return

        System.out.println("edit");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {

        //1.获取表单参数，
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String oldName = req.getParameter("oldName");
        String address = req.getParameter("address");
        //2,检验name是否已经被占用
        if (!oldName.equals(name)){
            long count = customersDAO.getCountWithName(name);
            //2.2先比较name和oldname 是否相同，若相同说明name可用
            if (count > 0){


                req.setAttribute("message","用户名"+name+"已经占用，请重新选择");
                //2.2 若返回值大于0，则相应newcustomer。jsp页面
                //通过转发的方法来相应newcustomers。jsp

                req.getRequestDispatcher("/updatecustomer.jsp").forward(req,resp);

                return;
            }
        }
        //3.调用CustomerDao的getCountwithName 获取name 在数据库汇总是否存在
        Customer customer = new Customer(name,address,phone);

        customer.setId(Integer.parseInt(id));


        customersDAO.update(customer);
        //测试

        resp.sendRedirect("query.do");
        System.out.println("update");
    }
    private void query(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        //获取模糊查询的请求参数
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        //把请求参数分装为一个CriteriaCustomer对象
        CriteriaCustomer cc = new CriteriaCustomer(name,address,phone);

//        List<Customer> customers = customersDAO.getForListWithCriterIaCustomer(cc);

        //1.直接调用CUstomers的getALl得到Customers的集合
        List<Customer> customers = customersDAO.getAll();
//        customersDAO.getAll();
        //2.把Customer的集合放到request中
        req.setAttribute("customers",customers);
        //3.转发页面到index不能使用重定向

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        System.out.println("query");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {

        String idStr = req.getParameter("id");
        int id=0;


        //trycatch  的作用：防止不能转的时候，，还是要进行转换
        try {
            id = Integer.parseInt(idStr);
            System.out.println(id);
            customersDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("query.do");
        }
        System.out.println("delete");
    }

    private void addCustomers(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {


        //1.获取表单参数
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        //1)检验名字是否被重复 利用getCountWithName方法 获取name 在数据库中是否存在
        //通过转发的方式来相应newCustomer.jsp
        long count = customersDAO.getCountWithName(name);
        //2）若返回值大于0，则相应newCustomer。jsp页面:
        //2.1) 名字占用，重新选在
        if (count > 0){
            request.setAttribute("message","用户名" +name + "已经占用，请重新选择！");

            request.getRequestDispatcher("/newcustomers.jsp").forward(request,response);
            return;
        }
        //2.2) newcustiomer。jsp 的表单可以回显
        //2.3 结束方法 return
        //可以通过request。getAttribut（message） 的方式显示


        //2,把表单参数封装为一个Customer 对象customer
        Customer customer = new Customer(name,address,phone);
        //3,调用CustomerDao的save方法
        customersDAO.save(customer);
        //4,重定向
        response.sendRedirect("sucess.jsp");
        System.out.println("add");
    }
}
