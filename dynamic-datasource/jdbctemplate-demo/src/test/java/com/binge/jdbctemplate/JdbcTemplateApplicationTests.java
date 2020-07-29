package com.binge.jdbctemplate;

import com.binge.jdbctemplate.dao.OrderDao;
import com.binge.jdbctemplate.dao.UserDao;
import com.binge.jdbctemplate.model.Order;
import com.binge.jdbctemplate.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JdbcTemplateApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;


    /**
     * 测试多数据源读写
     */
    @Test public void testSave(){
        userDao.save("insert into t_user(id, name) values(?, ?)", new User(789, "xiaohong"));
        orderDao.save("insert into t_order(id, user_id) values(?, ?)", new Order(789, 789));
    }

    @Test public void testQuery(){
        User user = userDao.userById("select id,name from t_user where id = ?", 789);
        System.out.println(user);
        Order order = orderDao.orderById("select id,user_id AS userId from t_order where id = ?", 789);
        System.out.println(order);
    }
}
