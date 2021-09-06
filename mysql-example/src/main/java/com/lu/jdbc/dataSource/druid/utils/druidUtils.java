package com.lu.jdbc.dataSource.druid.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 21:51
 */
public class druidUtils {

    public static DataSource dataSource;

    static {
        try {
            // 1.创建属性集对象
            Properties properties = new Properties();

            // 2.加载配置文件 Druid 连接池不能够主动加载配置文件 ,需要指定文件
            InputStream inputStream = druidUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            // 3.使用Properties对象的 load方法 从字节流中读取配置信息
            properties.load(inputStream);

            // 4. 通过工厂类获取连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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

