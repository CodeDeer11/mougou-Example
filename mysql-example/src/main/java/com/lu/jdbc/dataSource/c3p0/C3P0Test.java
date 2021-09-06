package com.lu.jdbc.dataSource.c3p0;

import com.lu.jdbc.dataSource.c3p0.utils.C3P0Utils;

import java.sql.*;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 21:37
 */
public class C3P0Test {
    public static void main(String[] args) throws SQLException {

        Connection connection = C3P0Utils.getConnection();

        String sql = "select * from employee where ename = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, "李白");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int eid = resultSet.getInt("eid");
            String ename = resultSet.getString("ename");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            double salary = resultSet.getDouble("salary");
            Date date = resultSet.getDate("empdate");
            System.out.println(eid + " " + ename + " " + age + " " + sex + " " + salary + " " + date);
        }
    }
}
