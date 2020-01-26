package com.javaweb.controller;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import com.javaweb.dao.UserDaoFactory;
import com.javaweb.service.LoginService;
import com.javaweb.service.factory.LoginServiceFactory;
import com.javaweb.service.UserService;
import com.javaweb.service.factory.UserServiceFactory;
import com.javaweb.utils.JdbcTools;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginTest
 * @Create : 2020/1/24
 * @Description :
 */
public class LoginTest {


    //采用这种模式，间接达到自动装配
    private UserDao userDao = UserDaoFactory.getInstance().getUserDAO();

    private UserService userService = UserServiceFactory.getInstance().getUserService();
    private LoginService loginService = LoginServiceFactory.getInstance().getLoginService();
    @Test
    public void test2() {

        /*
        可以传回来数据，可是回到loginServiceImpl
         */
        /*
         这里需要改下，不是传入 对象，而是传入参数吧，因为我这里无法装配，达不到有框架的效果，
         可以尝试下，工厂模式，看看
         */
        // User  user = loginService.putLogin(new User(1,"zhangsna","1234","男",14,"2020-2-14"));
        // System.out.println(user.toString());


        // System.out.println(userService.addUser(new User("你好222", "1345", "1", 14, "2020-2-14")).toString());
        // System.out.println(userService.deleteUser(new User(11)));
        System.out.println(userService.selectUser());
    }

    @Test
    public void test1() {

        // System.out.println(loginService.putLogin(new User("zhangsan", "1234")));


        // loginService.queryLogin(new User("zhangsan", "1234"));
        User user = loginService.queryLogin(new User("zhangsan","1234"));
        System.out.println(user.toString());
    }


    @Test
    public void test() {

        /**
         * userDao 数据正常
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        try {
            connection = JdbcTools.getConnection();

            String sql = "select *  from t_user where uname = ? and pwd = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, "zhangsan");
            preparedStatement.setObject(2, "1234");

            resultset = preparedStatement.executeQuery();

            ResultSetMetaData data = resultset.getMetaData();
            User u = null;
            while(resultset.next()){
                u = new User();
                // System.out.println(resultset.getInt(data.getColumnName(1)));
                System.out.println(resultset.getInt(1));
                // System.out.println(resultset.getRow());
                u.setUid(resultset.getInt(1));
                u.setUname(resultset.getString("uname"));
                // u.setPwd(resultset.getString("pwd"));
                // u.setSex(resultset.getString("sex"));
                // u.setAge(resultset.getInt("age"));
                // u.setBirth(resultset.getString("birth"));

            }


            // System.out.println(u.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }


}
