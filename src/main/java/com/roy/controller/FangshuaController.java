package com.roy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 23:22 2021-02-03
 */
@Controller
public class FangshuaController {

  /*@Value("${zhangjin}")
  private String zhangjin;*/

  //  @AccessLimit(seconds = 5, maxCount = 5, needLogin = true)
  @RequestMapping("/fangshua")
  @ResponseBody
  public String fangshua() {

    /*System.out.println("888888" + zhangjin);*/
    return "ok";
  }
}
