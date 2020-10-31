package com.demo.dao;

import java.util.List;

public interface RoleUserDao {
    int addRoleUser(int uid, int rid);

    List<Integer> findAllRidByUid(int uid);

    boolean deleteRoleUser(int uid, int rid);
}
