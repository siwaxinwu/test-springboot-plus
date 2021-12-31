package com.roy.service.impl;

import com.roy.dto.HeartBeatInfo;
import com.roy.service.HeartBeatTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/1 20:24
 */
@Service
public class HeartBeatTaskServiceImpl implements HeartBeatTaskService {
  @Resource
  private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

  @Override
  public void sendBeatInfo() {
    HeartBeatInfo heartBeatInfo = new HeartBeatInfo();
    heartBeatInfo.setInfo("test-info");
    heartBeatInfo.setNextSendTimeDelay(1000);
    scheduledThreadPoolExecutor.schedule(
        new HeartBeatTask(heartBeatInfo),
        heartBeatInfo.getNextSendTimeDelay(),
        TimeUnit.MILLISECONDS);
  }

  class HeartBeatTask implements Runnable {
    private HeartBeatInfo heartBeatInfo;

    public HeartBeatTask(HeartBeatInfo heartBeatInfo) {
      this.heartBeatInfo = heartBeatInfo;
    }

    @Override
    public void run() {
      System.out.println("发送心跳数据包:" + heartBeatInfo.getInfo());
      HeartBeatInfo heartBeatInfo = new HeartBeatInfo();
      heartBeatInfo.setInfo("test-info");
      heartBeatInfo.setNextSendTimeDelay(1000);
      scheduledThreadPoolExecutor.schedule(
          new HeartBeatTask(heartBeatInfo),
          heartBeatInfo.getNextSendTimeDelay(),
          TimeUnit.MILLISECONDS);
    }
  }
}
