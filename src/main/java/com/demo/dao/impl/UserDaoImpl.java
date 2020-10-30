package com.demo.dao.impl;

import com.demo.dao.UserDao;
import com.demo.model.User;
import com.demo.util.MyMD5;
import com.demo.util.db.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private ResultSet rs;

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
        String sql = "insert into users(uid, uname, passwd) values (?,?,?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, passwordMD5);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByName(user.getName());
    }
}