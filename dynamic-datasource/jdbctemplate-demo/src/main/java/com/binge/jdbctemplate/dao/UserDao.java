package com.binge.jdbctemplate.dao;


import com.binge.jdbctemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate userJdbcTemplate;

    public void save(String sql, User user){
        userJdbcTemplate.update(sql, user.getId(), user.getName());
    }

    public User userById(String sql, Integer id){
        return userJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }
}
