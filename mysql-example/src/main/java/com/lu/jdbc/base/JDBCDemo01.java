package com.lu.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-08-31 0:08
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.注册驱动（可省略）
//        Class.forName("com.mysql.jdbc.Driver");

        // 2.获取连接 url,帐号,密码
        String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        // 3.获取 statement 对象
        Statement statement = connection.createStatement();

        // 4.执行表操作
        String sql = "create table test01(id int, name varchar(20),age int);";
        int i = statement.executeUpdate(sql); // 影响行数
        System.out.println(i);

        // 5.关闭流
        statement.close();
        connection.close();
    }
}
