package com.roy.service.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 短信监听器
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 7:51
 * @Description
 */
@Component
public class SmsListener implements ApplicationListener<OrderCreateEvent> {

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        //发送短信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");

    }
}
