package com.binge.mybatis.dao;


import com.binge.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserAnnotationDao {

    @Insert("INSERT INTO t_user VALUES(#{id}, #{name})")
    void save(User user);

    @Select("SELECT * FROM t_user")
    List<User> allUsers();
}
