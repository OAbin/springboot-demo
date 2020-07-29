package com.binge.jpa;

import com.binge.jpa.dao.order.OrderRepository;
import com.binge.jpa.dao.user.UserRepository;
import com.binge.jpa.model.Order;
import com.binge.jpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaApplicationTests {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;



    /**
     * 测试多数据源读写
     */
    @Test public void testSave(){
        userRepository.save(new User(678, "xiaohong"));
        orderRepository.save(new Order(678, 456));
    }

    @Test public void testQuery(){
        User user = userRepository.findById(678);
        System.out.println(user);
        Order order = orderRepository.findById(678);
        System.out.println(order);
    }

}
