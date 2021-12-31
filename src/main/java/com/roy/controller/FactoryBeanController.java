package com.roy.controller;

import com.roy.service.MyFactoryBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@RequestMapping("/factory")
//@RestController
public class FactoryBeanController {

  @Autowired MyFactoryBeanService myFactoryBeanService;



  @RequestMapping("/test")
  public String test() {
    myFactoryBeanService.test();
    return "test ok";
  }
}
