package com.roy.service.strategy.chain;

import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 7:59 2021-03-02
 */
@Service("close")
public class CloseStrategyHandler extends StrategyHandler {
  @Override
  public void push(String code) {
    if ("close".equals(code)) {
      System.out.println("在close这儿处理了");
    } else {
      getNext().push(code);
    }
  }
}
