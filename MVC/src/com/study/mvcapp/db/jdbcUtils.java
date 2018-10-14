package com.study.mvcapp.db;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-22:26
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc 操作的工具类
 */
public class jdbcUtils {

    private  static DataSource dataSource = null;

    static {
        //数据源只能被创建一次
        dataSource = new ComboPooledDataSource("mvcapp");

    }
    /**
     * 释放Connection 连接
     * @param connection
     */
    public static void releaseConnection(Connection connection){

        try {
            if (connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 返回数据源的一个Connection对象
     * @return
     */
    public static Connection getConnection() throws SQLException {


        return dataSource.getConnection();
    }
}
