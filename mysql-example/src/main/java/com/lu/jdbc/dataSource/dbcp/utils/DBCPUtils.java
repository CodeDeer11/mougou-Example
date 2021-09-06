package com.lu.jdbc.dataSource.dbcp.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 21:05
 */
public class DBCPUtils {

    // 1.定义常量，保存数据库相关信息
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db5?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // 2.创建连接池对象
    public static BasicDataSource dataSource = new BasicDataSource();

    // 3.使用静态代码块进行配置
    static {
        dataSource.setDriverClassName(DRIVERNAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    // 4.获取连接的方法
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    // 5.释放资源方法
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
