package com.demo.dao.impl;

import com.demo.dao.RoleDao;
import com.demo.model.Role;
import com.demo.util.db.DBUtils;

import java.sql.*;

public class RoleDaoImpl implements RoleDao {
    @Override
    public int addRole(Role role) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into role(rid, name,status) values(?,?,?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,1);
            ps.setString(2, role.getName());
            ps.setInt(3, role.getStatus());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Role findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from role where rid=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Role role = new Role();
                role.setRid(id);
                role.setName(rs.getString(2));
                role.setStatus(rs.getInt(3));
                return role;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRole(Role role) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update role set name=?,status=? where rid=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,role.getName());
            ps.setInt(2,role.getStatus());
            ps.setInt(3, role.getRid());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
