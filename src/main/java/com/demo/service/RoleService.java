package com.demo.service;

import com.demo.model.Access;
import com.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    /**
     * 给角色赋予某个权限
     * @param rid
     * @param aid
     * @param module
     * @return
     */
    boolean giveAccess(int rid, int aid, String module);

    /**
     * 从某个角色移除某个权限
     * @param rid
     * @param aid
     * @return
     */
    boolean removeAccess(int rid, int aid);

    Role getRole(int rid);

    int addRole(Role role);

    /**
     * 获取角色所属的所有权限
     * @param rid
     * @return
     */
    Set<Access> getAllAccesses(int rid);
}

