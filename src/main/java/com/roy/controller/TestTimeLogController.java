package com.roy.controller;

import com.roy.entity.User;
import com.roy.service.UserService;
import com.roy.service.strategy.PushStrategy;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/user1")
@RestController
@Slf4j
public class TestTimeLogController {

  @RequestMapping("/test")
  public String test() {
    try{
      throw new RuntimeException("参数错误");
    }catch (Exception e){
      log.error("error result", e);
    }
    return "test ok";
  }
}
