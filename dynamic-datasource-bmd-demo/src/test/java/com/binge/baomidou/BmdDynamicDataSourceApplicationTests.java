package com.binge.baomidou;

import com.binge.baomidou.mapper.OrderMapper;
import com.binge.baomidou.mapper.OrderProxyMapper;
import com.binge.baomidou.mapper.UserMapper;
import com.binge.baomidou.model.Order;
import com.binge.baomidou.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BmdDynamicDataSourceApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderProxyMapper proxyMapper;


    /**
     * 简单测试多数据源读写
     */
    @Test public void testSave(){
        userMapper.save(new User(345, "xiaohong"));
        orderMapper.save(new Order(345, 345));
    }

    @Test public void testQuery(){
        User user = userMapper.userById(345);
        System.out.println(user);
        Order order = orderMapper.orderById(345);
        System.out.println(order);
    }

    /**
     * 测试事务，事务注解会让baomidou动态数据源失效
     * TODO
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
     * 测试读写分离,分别向主库，从库分别插入id为1，userId为2，3的数据
     */
    @Test public void testSaveMaster(){
        proxyMapper.save(new Order(1, 1));
    }

    /**
     * 测试从库负载均衡，默认轮训机制来做负载均衡
     */
    @Test public void testQuerySlave(){
        for (int i = 0; i < 10; i++) {
            Order order = proxyMapper.orderById(1);
            System.out.println(order);
        }
    }
}
