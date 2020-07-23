package com.binge.mybatis;

import com.binge.mybatis.dao.UserAnnotationDao;
import com.binge.mybatis.dao.UserMapperDao;
import com.binge.mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserAnnotationDao annotationDao;
    @Autowired
    private UserMapperDao mapperDao;

    @Test public void testSave(){
        annotationDao.save(new User("123456", "xiaohong"));
        mapperDao.save(new User("123456", "xiaobin"));
    }

    @Test public void allUsers(){
        List<User> users = annotationDao.allUsers();
        System.out.println(Arrays.toString(users.toArray()));
        List<User> mapperUsers = mapperDao.allUsers();
        System.out.println(Arrays.toString(mapperUsers.toArray()));
    }

}
