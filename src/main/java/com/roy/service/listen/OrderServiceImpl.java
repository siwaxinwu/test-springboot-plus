package com.roy.service.listen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 7:52
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void saveOrder() {
        //1.创建订单
        System.out.println("订单创建成功");
        //2.发布事件
        List<String> contentList = new ArrayList<>();
        contentList.add("heling");
        contentList.add("123456789");
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(this, "订单创建", contentList);
        //ApplicationContext是我们的事件容器上层，我们发布事件，也可以通过此容器完成发布
        applicationContext.publishEvent(orderCreateEvent);
        //applicationEventPublisher.publishEvent(orderCreateEvent);//也可以
        System.out.println("finished!");
    }
}
