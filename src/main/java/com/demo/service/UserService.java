package com.demo.service;

import com.demo.model.Access;
import com.demo.model.Role;
import com.demo.model.User;

import java.util.List;

public interface UserService {
    User getUser(String name);

    /**
     * 为用户赋予某个角色
     * @param uid
     * @param rid
     * @return
     */
    boolean giveRole(int uid, int rid);

    /**
     * 获取用户所属的所有角色
     * @param uid
     * @return
     */
    List<Role> getAllRoles(int uid);

    /**
     * 移除用户的某个角色
     * @param uid
     * @param rid
     * @return
     */
    boolean removeRole(int uid, int rid);

    User addUser(User user);

    /**
     * 获取用户的权限列表
     * @param uid
     * @return
     */
    List<Access> getAllAccesses(int uid);
}
