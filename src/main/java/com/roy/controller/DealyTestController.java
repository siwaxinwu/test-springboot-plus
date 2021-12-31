package com.roy.controller;

import com.roy.service.dealytest.Consumer;
import com.roy.service.dealytest.DelayMsg;
import com.roy.service.dealytest.RedisDelayListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 16:44
 */
//@RestController
public class DealyTestController {


    private static final String TEST_DELAY_QUEUE = "test";
    private static final String DEMO_DELAY_QUEUE = "demo";
    @Autowired
    private RedisDelayListWrapper redisDelayListWrapper;

    private Random random = new Random();


    @GetMapping(path = "publish")
    public String publish(String msg, Long delayTime) {
        if (delayTime == null) {
            //这样写可读性比较强
            delayTime = 10_000L;
        }

        String queue = random.nextBoolean() ? TEST_DELAY_QUEUE : DEMO_DELAY_QUEUE;
        msg = queue + "#" + msg + "#" + (System.currentTimeMillis() + delayTime);
        redisDelayListWrapper.publish(queue, msg, delayTime);
        System.out.println("延时: " + delayTime + "ms后消费: " + msg + " now:" + LocalDateTime.now());
        return "success!";
    }


    @Consumer(topic = TEST_DELAY_QUEUE)
    public void consumer(DelayMsg delayMsg) {
        System.out.println("TEST消费延时消息: " + delayMsg + " at:" + System.currentTimeMillis());
    }

    @Consumer(topic = DEMO_DELAY_QUEUE)
    public void consumerDemo(DelayMsg delayMsg) {
        System.out.println("DEMO消费延时消息: " + delayMsg + " at:" + System.currentTimeMillis());
    }
}
