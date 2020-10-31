package com.demo.util.factory;

import com.demo.dao.*;
import com.demo.dao.impl.*;

public interface DaoFactory {
    UserDao getUserDao();
    AccessDao getAccessDao();
    RoleUserDao getRoleUserDao();
    RoleDao getRoleDao();
    RoleAccessDao getRoleAccessDao();
}
