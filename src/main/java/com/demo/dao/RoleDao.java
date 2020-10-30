package com.demo.dao;

import com.demo.model.Role;

public interface RoleDao {
    int addRole(Role role);

    Role findById(int id);

    boolean updateRole(Role role);
}
