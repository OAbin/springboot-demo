package com.binge.mybatis;

import com.binge.mybatis.mapper.order.OrderMapper;
import com.binge.mybatis.mapper.user.UserMapper;
import com.binge.mybatis.model.Order;
import com.binge.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 测试多数据源读写
     */
    @Test public void testSave(){
        userMapper.save(new User(135, "xiaohong"));
        orderMapper.save(new Order(135, 135));
    }

    @Test public void testQuery(){
        User user = userMapper.userById(135);
        System.out.println(user);
        Order order = orderMapper.orderById(135);
        System.out.println(order);
    }
}
