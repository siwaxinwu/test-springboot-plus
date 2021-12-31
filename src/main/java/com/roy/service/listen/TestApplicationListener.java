package com.roy.service.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ApplicationContext 被初始化或刷新时，该事件被发布。
 * 这也可以在 ConfigurableApplicationContext接口中使用 refresh() 方法来发生。
 * 此处的初始化是指：所有的Bean被成功装载，后处理Bean被检测并激活，所有Singleton Bean 被预实例化，
 * ApplicationContext容器已就绪可用。
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-13 12:56
 */
@Component
public class TestApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(contextRefreshedEvent);
        System.out.println("TestApplicationListener............................");
    }
}
