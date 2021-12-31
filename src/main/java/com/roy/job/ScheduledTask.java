package com.roy.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-08-25 17:22
 */
@Component
public class ScheduledTask {

    //@Scheduled(cron = "0/1 * * * * ?")
    @Async("asyncTaskExecutor")
    public void scheduledTask1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "---scheduledTask1 " + System.currentTimeMillis());
        //多个定时任务时串行执行的,如果一个任务出现阻塞，其他的任务都会受到影响。
        /*while (true) {
            Thread.sleep(5000);
        }*/
    }

    //@Scheduled(cron = "0/1 * * * * ?")
    @Async("asyncTaskExecutor")
    public void scheduledTask2() {
        System.out.println(Thread.currentThread().getName() + "---scheduledTask2 " + System.currentTimeMillis());
    }
}