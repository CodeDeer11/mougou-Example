package com.lu.jdbc.dataSource.druid;

import com.lu.jdbc.dataSource.druid.utils.druidUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 22:10
 */
public class druidTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = druidUtils.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select ename from employee where salary between 3000 and 5000");

        while(resultSet.next()){
            String ename = resultSet.getString("ename"); System.out.println(ename);
        }

        druidUtils.close(connection, statement, resultSet);
    }
}
