package com.demo.dao.impl;

import com.demo.dao.UserDao;
import com.demo.model.User;
import com.demo.util.MyMD5;
import com.demo.util.db.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User findByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from users where uname=?;";
        List<User> users = new ArrayList();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            if (users.size() != 0)
                return users.get(0);
            else
                return null;
        } catch (SQLException e) {
            DBUtils.close(rs, ps,conn);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        String passwordMD5 = MyMD5.encrypt(user.getPassword());
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into users(uname, passwd) values (?,?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, passwordMD5);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()){
                user.setId(rs.getInt(1));
                return user;
            }
        } catch (SQLException e) {
            DBUtils.close(rs, ps,conn);
            e.printStackTrace();
        }
        return null;
    }
}
