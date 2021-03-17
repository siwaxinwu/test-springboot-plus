package com.roy.controller;

import com.roy.entity.User;
import com.roy.service.UserService;
import com.roy.service.strategy.PushStrategy;
import com.roy.service.strategy.StrategyManager;
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
@RequestMapping("/strategy")
@RestController
public class StrategyController  {

  @Autowired
  private StrategyManager strategyManager;


  @RequestMapping("/test")
  public void test() {
    strategyManager.push("add", "123");
  }


}
