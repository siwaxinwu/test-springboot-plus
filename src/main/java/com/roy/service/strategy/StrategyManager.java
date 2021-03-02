package com.roy.service.strategy;

import com.roy.annotation.StrategyCode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 21:51 2021-03-01
 */
@Service
public class StrategyManager implements ApplicationListener<ContextRefreshedEvent> {
  private static Map<String, PushStrategy> map = null;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext applicationContext = event.getApplicationContext();
    Map<String, Object> beansWithAnnotation =
        applicationContext.getBeansWithAnnotation(StrategyCode.class);
    map = new HashMap<>();
    beansWithAnnotation.forEach(
        (key, value) -> {
          String bizType = value.getClass().getAnnotation(StrategyCode.class).value();
          map.put(bizType, (PushStrategy) value);
        });
  }
}
