package com.binge.baomidou.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.binge.baomidou.constants.BaomidouConstants;
import com.binge.baomidou.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(BaomidouConstants.DATASOURCE_USER)
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
