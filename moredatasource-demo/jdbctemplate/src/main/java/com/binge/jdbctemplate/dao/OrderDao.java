package com.binge.jdbctemplate.dao;


import com.binge.jdbctemplate.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate orderJdbcTemplate;

    public void save(String sql, Order order){
        orderJdbcTemplate.update(sql, order.getId(), order.getUserId());
    }

    public Order orderById(String sql, Integer id){
        return orderJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class), id);
    }
}
