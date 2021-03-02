package com.roy.controller;

import com.roy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@RequestMapping("/user2")
@RestController
public class UserController2 implements ApplicationListener<ContextRefreshedEvent> {

  private ApplicationContext applicationContext;
  /**
   * 如何获取spring容器对象
   *
   * @return {@link String}
   */
  @RequestMapping("/test2")
  public String test() {
    UserService userService = (UserService) applicationContext.getBean("userService");
    System.out.println(userService.createUser());
    return "test ok";
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    this.applicationContext = event.getApplicationContext();
  }
}
