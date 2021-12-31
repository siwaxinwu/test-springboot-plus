package com.roy.service.dealytest;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 16:28
 */
public class MtDelayTask implements ApplicationContextAware {

    private ApplicationContext applicationContext;




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
