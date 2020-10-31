package com.demo.dao;

import com.demo.model.Access;

public interface AccessDao {
    int addAccess(Access access);

    Access findByAid(int aid);

}
