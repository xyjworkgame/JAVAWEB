package test;

import com.study.mvcapp.db.jdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-12-13:48
 */
public class jdbcUtilsTest {

    @Test
    public void releaseConnection() {
    }

    @Test
    public void getConnection() throws SQLException {
        Connection connection = jdbcUtils.getConnection();

        System.out.println(connection);
    }
}