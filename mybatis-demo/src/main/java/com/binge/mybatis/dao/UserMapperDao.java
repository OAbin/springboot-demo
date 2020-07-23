package com.binge.mybatis.dao;


import com.binge.mybatis.model.User;

import java.util.List;

public interface UserMapperDao {

    /**
     * save user
     * @param user
     */
    void save(User user);

    /**
     * query users
     * @return
     */
    List<User> allUsers();
}
