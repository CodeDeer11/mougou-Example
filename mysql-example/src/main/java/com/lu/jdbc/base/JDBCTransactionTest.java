package com.lu.jdbc.base;

import com.lu.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-01 22:11
 */
public class JDBCTransactionTest {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false); // 手动开启事务
            ps = connection.prepareStatement("update account set money = money - ? where name = ?");
            ps.setDouble(1,500.0);
            ps.setString(2,"tom");
            ps.executeUpdate();

            // 模拟异常
            System.out.println(1 / 0);

            ps = connection.prepareStatement("update account set money = money + ? where name = ?");
            ps.setDouble(1,500.0);
            ps.setString(2,"jack");
            ps.executeUpdate();

            connection.commit();
            System.out.println("转账成功");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCUtils.close(connection, ps);
        }
    }
}
