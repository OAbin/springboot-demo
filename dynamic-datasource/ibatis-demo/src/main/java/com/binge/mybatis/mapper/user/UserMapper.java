package com.binge.mybatis.mapper.user;

import com.binge.mybatis.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 根据id查询user对象
     * @param id
     * @return
     */
    User userById(@Param("id") Integer id);

    /**
     * 保存user
     * @param user
     */
    void save(User user);
}
