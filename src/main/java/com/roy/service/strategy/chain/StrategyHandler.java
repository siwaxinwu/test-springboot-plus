package com.roy.service.strategy.chain;

import lombok.Data;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 7:48 2021-03-02
 */
@Data
public abstract class StrategyHandler {

  public StrategyHandler next;

  public abstract void push(String code);
}
