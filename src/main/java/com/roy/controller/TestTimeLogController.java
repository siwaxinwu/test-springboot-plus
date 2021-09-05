package com.roy.controller;

import com.roy.entity.User;
import com.roy.logging.TimeLog;
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
@RequestMapping("/user1")
@RestController
public class TestTimeLogController {

  @RequestMapping("/test")
  @TimeLog
  public String test() {
    return "test ok";
  }
}
