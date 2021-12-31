package com.roy.controller;

import com.roy.service.GuavaRateLimiterService;
import com.roy.service.RateLimitAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 简单的Guava RateLimiter实现接口API限流
 * @author: Ding Yawu
 * @create: 2021-09-27 17:13
 */
@RestController
public class TestRateLimiterController {

    @Autowired
    private GuavaRateLimiterService rateLimiterService;

    @RequestMapping("/ratelimiter")
    @RateLimitAspect
    public String testRateLimiter(){
        if(rateLimiterService.tryAcquire()){
            return "no";
        }
        return "yes";
    }

    @RequestMapping("/dyw")
    public String testRateLimiter1(){
    System.out.println("yes");
        return "yes";
    }
}
