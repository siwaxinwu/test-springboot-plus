package com.roy.controller;

import com.roy.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** description： author：dingyawu date：created in 23:34 2020/11/21 history: */
@RequestMapping("/json")
@RestController
public class TestJsonController {

//  @Autowired
//  MyJsonService myJsonService;

  @RequestMapping("/test")
  public String test() {
//    Student student = new Student();
//    student.setAge("20");
//    student.setName("roy");
//    String myJson = myJsonService.objectToMyJson(student);
//    return myJson;
    return "ok";
  }
}
