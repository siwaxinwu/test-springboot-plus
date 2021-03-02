package com.roy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 17:38 2021-02-16
 */
@RestController
@Slf4j
public class TestStopProjectController {
  @GetMapping(value = "/test")
  public String test() {
    log.info("test --- start");
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("test --- end");
    return "test";
  }
}
