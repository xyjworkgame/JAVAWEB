package com.javaweb.dao.impl;

import com.javaweb.bean.User;
import com.javaweb.dao.UserDao;
import com.javaweb.utils.AjaxResult;
import com.javaweb.utils.JdbcTools;

import javax.naming.ldap.PagedResultsResponseControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: LoginDao
 * @Create : 2020/1/24
 * @Description :
 */
public class UserDaoImpl implements UserDao {

    /**
     *
     *判断用户登录存在用户登录
     * @param user
     * @return
     */
    @Override
    public User queryLogin(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        try {
            connection = JdbcTools.getConnection();

            String sql = "select *  from t_user where uname = ? and pwd = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, user.getUname());
            preparedStatement.setObject(2, user.getPwd());

            resultset = preparedStatement.executeQuery();


            User u = null;
            while (resultset.next()) {
                u = new User();
                u.setUid(resultset.getInt("uid"));
                u.setUname(resultset.getString("uname"));
                u.setPwd(resultset.getString("pwd"));
                u.setSex(resultset.getString("sex"));
                u.setAge(resultset.getInt("age"));
                u.setBirth(resultset.getString("birth"));

            }
            return u;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcTools.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 修改用户登录的数据
     * @param user
     * @return
     */
    @Override
    public AjaxResult putLogin(User user) {
        AjaxResult ajaxResult = new AjaxResult();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcTools.getConnection();

            String sql = "update t_user set uname = ? , pwd =?,sex =?,age=?,birth=? where uid = ?;";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, user.getUname());
            preparedStatement.setObject(2, user.getPwd());
            preparedStatement.setObject(3, user.getSex());
            preparedStatement.setObject(4, user.getAge());
            preparedStatement.setObject(5, user.getBirth());
            preparedStatement.setObject(6, user.getUid());

            Boolean booolena = preparedStatement.execute();
            // System.out.println(resultSet);

            System.out.println(booolena);

            ajaxResult.setData(user);
            ajaxResult.setSuccess(booolena);
            return ajaxResult;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTools.releaseConnection(connection);
        }
        ajaxResult.setSuccess(false);
        ajaxResult.setData(user);
        return ajaxResult;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public AjaxResult addUser(User user)
    {
        //本来可以是添加 AjaxResult 来代替的，这里懒得改了，
        AjaxResult result = new AjaxResult();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        int b = -1;
        try {
            connection = JdbcTools.getConnection();

            String sql = "insert into t_user  values(default ,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, user.getUname());
            preparedStatement.setObject(2, user.getPwd());
            preparedStatement.setObject(3, user.getSex());
            preparedStatement.setObject(4, user.getAge());
            preparedStatement.setObject(5,user.getBirth());

            b = preparedStatement.executeUpdate();

            System.out.println(b);

            if (b == -1) {
                result.setSuccess(false);
            }else {
                result.setSuccess(true);
            }
            // result.setSuccess(b);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcTools.releaseConnection(connection);
        }
        // result.setSuccess(false);
        return result;
    }


    @Override
    public AjaxResult deleteUser(User user) {

        //根据 user id 删除 用户

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        AjaxResult ajaxResult = null;

        int b =0;
        try {
            connection = JdbcTools.getConnection();

            String sql = " delete from t_user where uid = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1,user.getUid());

            b = preparedStatement.executeUpdate();
            System.out.println(b);
            if (b == 0){
                ajaxResult.setSuccess(false);
            }else {
                ajaxResult.setSuccess(true);
            }
            // ajaxResult.setSuccess(bool);

            return ajaxResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ajaxResult.setSuccess(false);
        return ajaxResult;
    }

    @Override
    public List<User> selectUser() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();
        ResultSet rs = null;
        try {
            connection = JdbcTools.getConnection();


            String sql = "SELECT * from t_user;";
            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()){
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                //将对象存储到集合中
                users.add(u);
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}