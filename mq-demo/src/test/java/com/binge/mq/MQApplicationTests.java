package com.binge.mq;

import com.binge.mq.rocketmq.RocketProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MQApplicationTests {

    @Autowired
    private RocketProducer producer;

    @Test public void testRocketSend(){
        producer.send("test_topic1", "this is test message");
    }
}
