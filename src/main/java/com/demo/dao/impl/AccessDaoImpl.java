package com.demo.dao.impl;

import com.demo.dao.AccessDao;
import com.demo.model.Access;
import com.demo.util.db.DBUtils;

import java.sql.*;

public class AccessDaoImpl implements AccessDao {
    @Override
    public int addAccess(Access access) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into access(aid, name, status, 'level') values (?,?,?,?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 1);
            ps.setString(2,access.getName());
            ps.setInt(3, access.getStatus());
            ps.setInt(4, access.getLevel());
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
    public Access findByAid(int aid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from access where aid=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, aid);
            rs = ps.executeQuery();
            while (rs.next()){
                Access access = new Access();
                access.setAid(aid);
                access.setName(rs.getString(2));
                access.setStatus(rs.getInt(3));
                access.setLevel(rs.getInt(4));
                return access;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
