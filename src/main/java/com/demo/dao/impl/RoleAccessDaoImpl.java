package com.demo.dao.impl;

import com.demo.dao.RoleAccessDao;
import com.demo.util.db.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleAccessDaoImpl implements RoleAccessDao {
    @Override
    public int addRoleAccess(int rid, int aid, String module) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into role_access(raid, role_id, access_id,module) values(?,?,?,?)";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setInt(2, rid);
            ps.setInt(3, aid);
            ps.setString(4,module);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> findAllAidByRid(int rid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select access_id from role_access where role_id=?";
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
    public boolean deleteRoleAccess(int rid, int aid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from role_access where access_id=? and role_id=?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.setInt(2,rid);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
