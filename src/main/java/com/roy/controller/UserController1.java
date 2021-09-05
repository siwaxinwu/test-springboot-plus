package com.roy.controller;

import com.roy.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@RequestMapping("/user1")
@RestController
public class UserController1 implements ApplicationContextAware {
	@Autowired
  private ApplicationContext applicationContext;

  /**
   * 如何获取spring容器对象
   *
   * @return {@link String}
   */
  @RequestMapping("/test1")
  public String test() {
    UserService userService = (UserService) applicationContext.getBean("userService");
    System.out.println(userService.createUser());
    return "test ok";
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}
