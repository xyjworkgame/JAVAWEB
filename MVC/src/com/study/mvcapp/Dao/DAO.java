package com.study.mvcapp.Dao;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-22:12
 */

import com.study.mvcapp.db.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 *封装了基本的CRUD的方法，以供子类继承使用
 * 当前DAO直接在方法中获取数据库连接
 * 整个DAO 采取DBUTils 解决方案
 * @param <T> 当前DAO 处理的实体类的的类型是什么
 */
public class DAO<T> {

    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;

    public DAO(){
        Type superclass = getClass().getGenericSuperclass();

        if (superclass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) superclass;

            Type [] typeArgs  = parameterizedType.getActualTypeArguments();
            if (typeArgs != null && typeArgs.length > 0){
                if (typeArgs[0] instanceof  Class){
                    clazz = (Class<T>) typeArgs[0];
                }
            }
        }
    }

    /**
     * 返回某一个字段的值，例如返回某一条记录的customerName ，或返回数据表中有多少条记录
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql,Object ... args){

        Connection connection = null;
        try{
            connection = jdbcUtils.getConnection();
            return (E) queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.releaseConnection(connection);
        }
        return  null;
    }
    /**
     * 返回 T 所对象的List
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForList(String sql,Object ... args){

        Connection connection = null;
        try {


            connection = jdbcUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.releaseConnection(connection);
        }
        return  null;

    }


    /**
     * 返回对应T的一个实例类的对象
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql , Object ... args){


        Connection connection = null;
        try{
            connection = jdbcUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.releaseConnection(connection);
        }
        return  null;
    }
    /**
     * 该方法封装了INSERT，DELETE，UPDASTE操作
     * @param sql  语句
     * @param args 填充sql 语句的占位符
     */
    public void update(String sql,Object ... args){

        Connection connection = null;

        try{
            connection = jdbcUtils.getConnection();
            queryRunner.update(connection,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.releaseConnection(connection);
        }
    }


}
