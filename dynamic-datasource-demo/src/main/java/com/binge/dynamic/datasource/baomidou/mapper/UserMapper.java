package com.binge.dynamic.datasource.baomidou.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.binge.dynamic.datasource.baomidou.constants.DataSourceConstants;
import com.binge.dynamic.datasource.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(DataSourceConstants.DATASOURCE_USER)
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
