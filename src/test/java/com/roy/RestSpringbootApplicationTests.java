package com.roy;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.apple.eawt.ApplicationBeanInfo;
import com.roy.service.DistributedLock;
import com.roy.service.listen.OrderService;
import com.roy.service.listen.email.EmailEvent;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RestSpringbootApplicationTests {

  @Autowired
  ApplicationContext ac;

  @Autowired
  OrderService orderService;

  @Autowired
  RedisTemplate<String, String> redisTemplate;

  /**
   * 演示springboot监听事件
   */
  @Test
  public void testOrderService() {
    orderService.saveOrder();
  }

  /**
   * 演示springboot监听事件
   */
  @Test
  public void testEmail() {
    //创建一个ApplicationEvent对象
    EmailEvent event = new EmailEvent("hello","abc@163.com","This is a test");
    //主动触发该事件
    ac.publishEvent(event);
  }


  @Test
  public void testDistribute() {
    redisTemplate.opsForValue().set("ding", "roy");
    String s = redisTemplate.opsForValue().get("ding");
    DistributedLock lock = ac.getBean(DistributedLock.class);
    lock.test();
  }

}
