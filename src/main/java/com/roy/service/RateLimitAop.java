package com.roy.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.catalina.startup.RealmRuleSet;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021-09-27 18:09
 */
@Component
@Scope
@Aspect
public class RateLimitAop {


    private RateLimiter rateLimiter = RateLimiter.create(5.0); //比如说，我这里设置"并发数"为5

    @Pointcut("@annotation(com.roy.service.RateLimitAspect)")
    public void serviceLimit() {

    }

    @Around("serviceLimit()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Boolean flag = rateLimiter.tryAcquire();
        Object obj = null;
        try {
            if (flag) {
                obj = joinPoint.proceed();
            }else{
                throw new RuntimeException("请求频繁，请稍后再试~");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("flag=" + flag + ",obj=" + obj);
        return obj;
    }
}