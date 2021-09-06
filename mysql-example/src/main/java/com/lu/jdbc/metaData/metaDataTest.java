package com.lu.jdbc.metaData;

import com.lu.jdbc.dataSource.druid.utils.druidUtils;
import org.junit.Test;

import java.sql.*;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-06 22:17
 */
public class metaDataTest {
    // 1.获取数据库相关的元数据信息 使用DatabaseMetaData
    @Test
    public void testDataBaseMetaData() throws SQLException {
        //1.获取数据库连接对象connection
        Connection connection = druidUtils.getConnection();
        //2.获取代表数据库的元数据对象DatabaseMetaData
        DatabaseMetaData metaData=connection.getMetaData();
        //3.获取数据库相关的元数据信息
        String url=metaData.getURL();
        System.out.println("数据库URL:"+url);

        String userName=metaData.getUserName();
        System.out.println("当前用户:"+userName);

        String productName=metaData.getDatabaseProductName();
        System.out.println("数据库产品名:"+productName);

        String version=metaData.getDatabaseProductVersion();
        System.out.println("数据库版本:"+version);

        String driverName=metaData.getDriverName();
        System.out.println("驱动名称:"+driverName);

        // 判断当前数据库是否只允许只读
        boolean b = metaData.isReadOnly();
        //如果是 true 就表示 只读
        if(b) {
            System.out.println("当前数据库只允许读操作!");
        } else {
            System.out.println("不是只读数据库");
        }
        connection.close();
    }

    @Test
    public void testResultSetMetaData() throws SQLException {
        Connection connection = druidUtils.getConnection();

        PreparedStatement ps = connection.prepareStatement("select * from employee");
        ResultSet resultSet = ps.executeQuery();

        ResultSetMetaData metaData = ps.getMetaData();

        int count = metaData.getColumnCount();
        System.out.println("当前结果集中共有: " + count + " 列");

        // 获结果集中 列的名称 和 类型
        for (int i = 1; i <= count; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.println("列名: "+ columnName);
            String columnTypeName = metaData.getColumnTypeName(i);
            System.out.println("类型: " +columnTypeName);
        }

        druidUtils.close(connection, ps, resultSet);
    }


}
