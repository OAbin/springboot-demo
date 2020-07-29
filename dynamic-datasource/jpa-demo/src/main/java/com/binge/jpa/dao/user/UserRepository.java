package com.binge.jpa.dao.user;


import com.binge.jpa.model.User;
import org.springframework.data.repository.Repository;


public interface UserRepository extends Repository<User, Integer> {

    /**
     * 保存user
     * @param user
     */
    void save(User user);

    /**
     * 根据id查询user
     * @param id
     * @return
     */
    User findById(Integer id);
}
