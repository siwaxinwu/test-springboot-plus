package com.roy.service.strategy.chain;

import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 7:56 2021-03-02
 */
//@Service("update")
public class UpdateStrategyHandler extends StrategyHandler {
  @Override
  public void push(String code) {
    if ("update".equals(code)) {
    } else {
      System.out.println("在update这儿处理了");
      getNext().push(code);
    }
  }
}
