package com.roy.service.strategy.chain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 7:47 2021-03-02
 */
@Service
@Lazy
public class StrategyHandlerChain implements InitializingBean {
  private StrategyHandler header;

  @Autowired private List<StrategyHandler> list;

  @Override
  public void afterPropertiesSet() throws Exception {
    for (int i = 0; i < list.size(); i++) {
      StrategyHandler strategyHandler = list.get(i);
      if (i != list.size() - 1) {
        strategyHandler.setNext(list.get(i + 1));
      }
    }
    header = list.get(0);
  }
}
