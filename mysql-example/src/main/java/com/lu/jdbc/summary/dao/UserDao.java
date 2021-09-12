package com.lu.jdbc.summary.dao;

import com.lu.jdbc.summary.entity.User;
import com.lu.jdbc.summary.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-12 21:16
 */
public class UserDao {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int register(User user) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?)";
        Object[] param = {user.getUid(), user.getUsername(),
        user.getPassword(), user.getTelephone(), user.getBirthday(), user.getSex()};
        int update = qr.update(sql, param);
        return update;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        User user = qr.query(sql, new BeanHandler<User>(User.class),
                username, password);
        return user;
    }
}
