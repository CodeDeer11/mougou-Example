package com.lu.jdbc.xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-08 0:38
 */
public class TestJDBC {
    //查询所有员工信息
    public static void main(String[] args) throws SQLException {

        //1.获取连接
        Connection connection = JDBCUtils.getConnection();

        //2.获取Statement 对象 执行SQL
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");

        //3.处理结果集
        while(resultSet.next()){

            String name = resultSet.getString("ename");
            System.out.println("员工的姓名: " + name);
        }

        //4.关闭资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
