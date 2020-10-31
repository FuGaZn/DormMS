package com.demo.util.factory.impl;

import com.demo.dao.*;
import com.demo.dao.impl.*;
import com.demo.util.factory.DaoFactory;

public class DaoFactoryImpl implements DaoFactory {
    UserDao userDao = new UserDaoImpl();
    RoleUserDao roleUserDao = new RoleUserDaoImpl();
    RoleDao roleDao = new RoleDaoImpl();
    RoleAccessDao roleAccessDao = new RoleAccessDaoImpl();
    AccessDao accessDao = new AccessDaoImpl();

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public AccessDao getAccessDao() {
        return accessDao;
    }

    @Override
    public RoleUserDao getRoleUserDao() {
        return roleUserDao;
    }

    @Override
    public RoleDao getRoleDao() {
        return roleDao;
    }

    @Override
    public RoleAccessDao getRoleAccessDao() {
        return roleAccessDao;
    }

}
