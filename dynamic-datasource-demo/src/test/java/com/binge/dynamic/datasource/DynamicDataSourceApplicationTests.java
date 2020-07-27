package com.binge.dynamic.datasource;

import com.binge.dynamic.datasource.baomidou.mapper.OrderMapper;
import com.binge.dynamic.datasource.baomidou.mapper.OrderProxyMapper;
import com.binge.dynamic.datasource.baomidou.mapper.UserMapper;
import com.binge.dynamic.datasource.model.Order;
import com.binge.dynamic.datasource.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class DynamicDataSourceApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderProxyMapper proxyMapper;


    @Test public void testSave(){
        userMapper.save(new User(123, "xiaohong"));
        orderMapper.save(new Order(123, 123));
    }

    @Test public void testQuery(){
        User user = userMapper.userById(123);
        System.out.println(user);

        Order order = orderMapper.orderById(123);
        System.out.println(order);
    }

    /**
     * 测试事务，事务注解会让baomidou动态数据源失效
     */
    @Test public void testTransactional(){
        testTran();
    }


    @Transactional
    public void testTran(){
        User user = userMapper.userById(123);
        System.out.println(user);

        Order order = orderMapper.orderById(123);
        System.out.println(order);
    }

    /**
     * 测试读写分离
     */
    @Test public void testSaveMaster(){
        proxyMapper.save(new Order(1, 1));
    }

    /**
     * 从库默认轮训机制负载均衡
     */
    @Test public void testQuerySlave(){
        for (int i = 0; i < 10; i++) {
            Order order = proxyMapper.orderById(1);
            System.out.println(order);
        }
    }
}
