package com.binge.mq.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RocketProducer {

    @Autowired
    private RocketMQTemplate template;

    /**
     *
     * @param topic
     * @param message
     */
    public void send(String topic, String message){
        template.convertAndSend(topic, message);
    }

    /**
     *
     * @param topic
     * @param message
     */
    public void send(String topic, String tag, String message){
        template.convertAndSend(topic.concat(":").concat(tag), message);
    }

    /**
     * 同步发送
     * @param topic
     * @param message
     */
    public void synSend(String topic, Object message){
        template.syncSend(topic, message);
    }

    /**
     * 异步发送
     * @param topic
     * @param message
     */
    public void asynSend(String topic, Object message){
        template.asyncSend(topic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("send success");
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("send failed");
            }
        });
    }

    /**
     * 发送即发即失消息（不关心发送结果）
     * @param topic
     * @param message
     */
    public void onceSend(String topic, Object message){
        template.sendOneWay(topic, message);
    }

    /**
     * 发送顺序消息
     * @param topic
     * @param message
     * @param key
     */
    public void orderlySend(String topic, Object message, String key){
        template.syncSendOrderly(topic, message, key);
    }

}
