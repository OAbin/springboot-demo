package com.binge.shardingjdbc;

import com.binge.shardingjdbc.mapper.OrderMapper;
import com.binge.shardingjdbc.mapper.UserMapper;
import com.binge.shardingjdbc.model.Order;
import com.binge.shardingjdbc.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShardingJdbcApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Test public void testSave(){
        userMapper.save(new User(110, "xiaohong"));
        orderMapper.save(new Order(110, 890));
    }

    @Test public void testQuery(){
        User user = userMapper.userById(110);
        System.out.println(user);
        Order order = orderMapper.orderById(110);
        System.out.println(order);
    }

}
