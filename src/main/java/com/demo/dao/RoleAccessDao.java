package com.demo.dao;

import com.demo.model.Node;

public interface NodeDao {
    int addNode(Node node);
    boolean deleteNode(int nid);
}
