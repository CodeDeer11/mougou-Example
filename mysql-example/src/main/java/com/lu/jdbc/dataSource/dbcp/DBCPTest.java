package com.lu.jdbc.dataSource.dbcp;

import com.lu.jdbc.dataSource.dbcp.utils.DBCPUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 21:17
 */
public class DBCPTest {
    public static void main(String[] args) throws SQLException {

        // 1.获取连接
        Connection connection = DBCPUtils.getConnection();

        // 2.获取 statement 对象
        Statement statement = connection.createStatement();

        // 3.查询所有员工姓名
        String sql = "select ename from employee";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4.处理结果集
        while (resultSet.next()) {
            String ename = resultSet.getString("ename");
            System.out.println("员工姓名：" + ename);
        }

        // 5.释放资源
        DBCPUtils.close(connection, statement, resultSet);
    }
}
