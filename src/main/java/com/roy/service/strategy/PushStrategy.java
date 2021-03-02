package com.roy.service.strategy;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:58 2021-02-24
 */
public abstract class PushStrategy {

  public abstract Boolean support(String code);

  public abstract Boolean push(String applyNo);
}
