package com.lu.jdbc.dataSource.c3p0.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 21:31
 */
public class C3P0Utils {

    // 1.创建连接池对象
//    public static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 1.使用指定的配置
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

    // 获取连接
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    // 释放资源
    public static void close(Connection connection, Statement statement) {
        if (null != connection && null != statement) {
            try {
                statement.close();
                connection.close();
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
