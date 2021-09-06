package com.lu.jdbc.utils;

import java.sql.*;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-08-31 0:22
 */
public class JDBCUtils {

    // 定义常量
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    // 静态代码块
    static {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 关闭资源
    public static void close(Connection connection, Statement statement) {
        if (null != connection && null != statement) {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close(connection, statement);
    }

}
