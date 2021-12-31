package com.roy.service;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 基于RedissonClient实现分布式锁，有自动续期的功能
 * @author: Ding Yawu
 * @create: 2021/11/14 20:28
 */
//@Service
public class DistributedLock {
    @Autowired
    private RedissonClient redissonClient;

    public void test(){
        RLock rLock = redissonClient.getLock("redisKey");
        try{
            //上锁
            rLock.lock();
            try{
                Thread.sleep(10000000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        } finally {
            //释放锁
            rLock.unlock();
        }
    }
}
