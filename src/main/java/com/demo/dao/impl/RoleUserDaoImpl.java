package com.demo.dao.impl;

import com.demo.dao.RoleUserDao;
import com.demo.util.db.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoleUserDaoImpl implements RoleUserDao {

    @Override
    public int addRoleUser(int uid, int rid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into role_user(ruid, role_id, user_id) values(?,?,?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setInt(2, rid);
            ps.setInt(3, uid);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> findAllRidByUid(int uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select role_id from role_user where user_id=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Integer> list = new ArrayList<>();
            while (rs.next()){
                list.add(rs.getInt(1));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteRoleUser(int uid, int rid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from role_user where user_id=? and role_id=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.setInt(2,rid);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
