package com.lu.jdbc.summary.app;

import com.lu.jdbc.summary.dao.OrdersDao;
import com.lu.jdbc.summary.entity.Orders;
import com.lu.jdbc.summary.entity.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestOrdersDao {

    OrdersDao ordersDao = new OrdersDao();

    @Test
    public void testFindAllOrders() throws SQLException {

        List<Orders> allOrders = ordersDao.findAllOrders("001");

        for (Orders orders : allOrders) {
            System.out.println(orders);
        }

    }

    //测试 获取订单编号为 order001的订单中的所有商品信息
    @Test
    public void testFindOrderById() throws SQLException {

        List<Product> order001 = ordersDao.findOrderById("order001");

        for (Product product : order001) {
            System.out.println(product);
        }
    }



}
