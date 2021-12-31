package com.roy.test;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 13:58
 */
@Component
public class TestDemo {
    public String showCase() {
        return UUID.randomUUID().toString();
    }

    public String testCase() {
        return "test-" + Math.random();
    }
}
