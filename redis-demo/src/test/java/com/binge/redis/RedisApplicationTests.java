package com.binge.redis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate jacksonRedisTemplate;

    @Test public void testSave(){
        jacksonRedisTemplate.opsForValue().set("test:234", "test123");
    }
}
