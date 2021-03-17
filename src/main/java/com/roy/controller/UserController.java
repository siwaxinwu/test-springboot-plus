package com.roy.controller;

import com.roy.entity.User;
import com.roy.service.UserService;
import com.roy.service.strategy.PushStrategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@RequestMapping("/user")
@RestController
public class UserController implements BeanFactoryAware {

  @Autowired private Map<String, PushStrategy> map = new HashMap<>();

  private List<PushStrategy> list = new ArrayList<>();
  private BeanFactory beanFactory;

  /**
   * 如何获取spring容器对象
   *
   * @return {@link String}
   */
  @RequestMapping("/test")
  public String test() {
    UserService userService = (UserService) beanFactory.getBean("userService");
    System.out.println(userService.createUser());
    return "test ok";
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  @RequestMapping("/test1")
  public Boolean test1() {
    PushStrategy pushStrategy = map.get("addPackageStrategy");
    return pushStrategy.support("");
  }

  @RequestMapping("/save")
  public String save(@RequestBody User user) {
    return "success";
  }
}
