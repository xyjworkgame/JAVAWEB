package com.Servelt.mvc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-10:59
 */
public class studentDao {

    public void deleteByFlowId(Integer flowid){
        List<student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            String driverClass = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///runoob";
            String user = "root";
            String password = "123456";

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,user,password);

            String sql = "delete from examstudent where flow_id =?";

            preparedStatement = connection.prepareStatement(sql);



            preparedStatement.setInt(1,flowid);

            preparedStatement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {

            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<student> getAll(){

        List<student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            String driverClass = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///runoob";
            String user = "root";
            String password = "123456";

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,user,password);

            String sql = "SELECT flow_id,Type,id_Card,exam_card,student_name,Location,Grade " +
                    "FROM examstudent";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int flowID = resultSet.getInt(1);
                int type = resultSet.getInt(2);
                String idCard = resultSet.getString(3);
                String examCard = resultSet.getString(4);
                String studentName = resultSet.getString(5);
                String location = resultSet.getString(6);
                int grade = resultSet.getInt(7);

                student student = new student(flowID,type,idCard,examCard,studentName,location,grade);

                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}
