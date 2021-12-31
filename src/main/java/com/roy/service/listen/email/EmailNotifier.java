package com.roy.service.listen.email;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义监听器
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-12 20:43
 */
@Component
public class EmailNotifier implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent)event;
            System.out.println("邮件地址：" + emailEvent.getAddress());
            System.out.println("邮件内容：" + emailEvent.getText());
        } else {
            System.out.println("容器事件：" + event);
        }
    }
}
