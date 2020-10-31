package com.demo.service.impl;

import com.demo.dao.*;
import com.demo.dao.impl.*;
import com.demo.model.Access;
import com.demo.model.Role;
import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.util.factory.DaoFactory;
import com.demo.util.factory.impl.DaoFactoryImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {
    DaoFactory daoFactory = new DaoFactoryImpl();
    @Override
    public User getUser(String name) {
        return daoFactory.getUserDao().findByName(name);
    }

    @Override
    public boolean giveRole(int uid, int rid) {
        daoFactory.getRoleUserDao().addRoleUser(uid, rid);
        return true;
    }

    @Override
    public Set<Role> getAllRoles(int uid) {
        List<Integer> rid_list = daoFactory.getRoleUserDao().findAllRidByUid(uid);
        Set<Role> roles = new HashSet<>();
        for (Integer rid: rid_list){
            Role role = daoFactory.getRoleDao().findById(rid);
            if (role!=null)
                roles.add(role);
        }
        return roles;
    }

    @Override
    public boolean removeRole(int uid, int rid) {
        return daoFactory.getRoleUserDao().deleteRoleUser(uid, rid);
    }

    @Override
    public User addUser(User user) {
        return daoFactory.getUserDao().createUser(user);
    }

    @Override
    public Set<Access> getAllAccesses(int uid) {
        Set<Role> roles = getAllRoles(uid);
        Set<Access> accessSet = new HashSet<>();
        for (Role role: roles){
            List<Integer> aidsOfRole = daoFactory.getRoleAccessDao().findAllAidByRid(role.getRid());
            for (Integer aid: aidsOfRole){
                Access access = daoFactory.getAccessDao().findByAid(aid);
                accessSet.add(access);
            }
        }
        return accessSet;
    }
}
