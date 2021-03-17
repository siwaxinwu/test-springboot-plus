package com.roy.service.strategy.chain;

import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 7:52 2021-03-02
 */
//@Service("add")
public class AddPackageStrategy extends StrategyHandler {

  @Override
  public void push(String code) {
    if ("add".equals(code)) {
      System.out.println("在add这儿处理了");
    } else {
      getNext().push(code);
    }
  }
}
