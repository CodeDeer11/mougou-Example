package com.lu.jdbc.summary.dao;

import com.lu.jdbc.summary.entity.Category;
import com.lu.jdbc.summary.entity.Product;
import com.lu.jdbc.summary.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-12 21:28
 */
public class ProductDao {


    /**
     * 根据商品 id 获取商品名称、价格、分类
     * @param pid
     * @return
     */
    public Product findProductById(String pid) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from product where pid = ?";
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);
        String cid = product.getCid();
        Category category = findCategoryById(cid);
        product.setCategory(category);
        return product;
    }

    /**
     * 根据分类 id 获取商品分类信息
     * @param cid
     * @return
     */
    public Category findCategoryById(String cid) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select count(*) from product where cid = ?";
        Category category = qr.query(sql, new BeanHandler<Category>(Category.class), cid);

        return category;
    }

    /**
     * 查询指定分类 id 下的商品个数
     * @param cid
     * @return
     * @throws SQLException
     */
    public int getCount(String cid) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select count(*) from product where cid = ?";

        //获取单列数据 使用 ScalarHandler 来封装
        Long count = qr.query(sql, new ScalarHandler<>(), cid);

        //将Long类型包装类 转换为int类型 并返回
        return count.intValue();
    }

    /**
     * 查询指定分类 id 下的所有商品信息
     * @param cid
     * @return
     * @throws SQLException
     */
    public List<Product> findProductByCid(String cid) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from product where cid = ?";

        // 查询结果是一个 list集合, 使用 BeanListHandler来封装
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), cid);

        return list;
    }
}
