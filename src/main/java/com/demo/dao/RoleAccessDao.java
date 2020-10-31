package com.demo.dao;


import java.util.List;

public interface RoleAccessDao {
    int addRoleAccess(int rid, int aid, String module);

    List<Integer> findAllAidByRid(int rid);

    boolean deleteRoleAccess(int rid, int aid);
}
