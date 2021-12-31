package com.roy.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 测试说明springboot的定时任务是单线程的，会造成阻塞
 * @author: Ding Yawu
 * @create: 2021/12/31 08:21
 */
//@Component
public class SingleScheduleTask {

    @Scheduled(cron = "*/1 * * * * ?")
    public void task1(){
        System.out.println("task1 execute" + Thread.currentThread().getName());
    }
    @Scheduled(cron = "*/1 * * * * ?")
    public void task2(){
        System.out.println("task2 execute" + Thread.currentThread().getName());
    }
}
