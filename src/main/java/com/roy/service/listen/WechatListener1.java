package com.roy.service.listen;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 8:37
 * @Description
 */
@Component
public class WechatListener1 implements SmartApplicationListener {


    /**
     * 设置监听优先级
     *
     * @return int
     */
    @Override
    public int getOrder() {
        return 1;
    }


    /**
     * 监听器智能所在之一，能够根据事件类型动态监听
     *
     * @param aClass 一个类
     * @return boolean
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }


    /**
     * 监听器智能所在之二，能够根据事件发布者类型动态监听
     *
     * @param aClass 一个类
     * @return boolean
     */
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceImpl.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        //发送微信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");

    }

    /*@Override
    @Async
    public void onApplicationEvent(OrderCreateEvent event) {

        //发送微信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");

    }*/
}