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

    /**
     * 测试多数据源读写
     */
    @Test public void testSave(){
        userMapper.save(new User(120, "xiaohong"));
        orderMapper.save(new Order(120, 890));
    }

    @Test public void testQuery(){
        User user = userMapper.userById(110);
        System.out.println(user);
        Order order = orderMapper.orderById(110);
        System.out.println(order);
    }

    /**
     * 注意:需要在application.yaml中放开读写分离配置
     * 测试读写分离,默认轮训机制
     */
    @Test public void testRW(){
        for (int i = 0; i < 10; i++) {
            Order order = orderMapper.orderById(1);
            System.out.println(order);
        }
    }

}
