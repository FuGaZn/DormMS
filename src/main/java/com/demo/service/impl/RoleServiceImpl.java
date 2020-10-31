package com.demo.service.impl;

import com.demo.model.Access;
import com.demo.model.Role;
import com.demo.service.RoleService;
import com.demo.util.factory.DaoFactory;
import com.demo.util.factory.impl.DaoFactoryImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleServiceImpl implements RoleService {
    DaoFactory daoFactory = new DaoFactoryImpl();
    @Override
    public boolean giveAccess(int rid, int aid, String module) {
        daoFactory.getRoleAccessDao().addRoleAccess(rid, aid, module);
        return true;
    }

    @Override
    public boolean removeAccess(int rid, int aid) {
        return daoFactory.getRoleAccessDao().deleteRoleAccess(rid, aid);
    }

    @Override
    public Role getRole(int rid) {
        return daoFactory.getRoleDao().findById(rid);
    }

    @Override
    public int addRole(Role role) {
        return daoFactory.getRoleDao().addRole(role);
    }

    @Override
    public Set<Access> getAllAccesses(int rid) {
        List<Integer> aid_list = daoFactory.getRoleAccessDao().findAllAidByRid(rid);
        Set<Access> accessSet = new HashSet<>();
        for (Integer aid: aid_list){
            accessSet.add(daoFactory.getAccessDao().findByAid(aid));
        }
        return accessSet;
    }
}
