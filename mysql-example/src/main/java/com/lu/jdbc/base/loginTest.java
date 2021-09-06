package com.lu.jdbc.base;

import com.lu.jdbc.utils.JDBCUtils;
import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-01 22:05
 */
public class loginTest {

    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from jdbc_user where username = ? and password = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        ps.setString(1, user);
        ps.setString(2, password);

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            System.out.println("登录成功！ " + user);
        } else {
            System.out.println("登录失败！");
        }

        JDBCUtils.close(connection, ps, resultSet);
    }
}
