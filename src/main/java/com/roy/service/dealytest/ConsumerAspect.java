package com.roy.service.dealytest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 16:30
 */
@Aspect
@Component
public class ConsumerAspect {

    @Around("@annotation(consumer)")
    public Object around(ProceedingJoinPoint joinPoint, Consumer consumer) throws Throwable {
        Object[] args = joinPoint.getArgs();
        boolean check = false;
        for (Object obj : args) {
            if (obj instanceof DelayMsg) {
                check = consumer.topic().equals(((DelayMsg) obj).getTopic());
            }
        }

        if (!check) {
            // 不满足条件，直接忽略
            return null;
        }

        // topic匹配成功，执行
        return joinPoint.proceed();
    }
}