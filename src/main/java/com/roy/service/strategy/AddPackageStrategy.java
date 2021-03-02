package com.roy.service.strategy;

import com.roy.annotation.StrategyCode;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 15:02 2021-02-24
 */
@Component("add")
@StrategyCode(value = "add", name = "增加策略")
public class AddPackageStrategy extends PushStrategy {

  @Override
  public Boolean push(String applyNo) {

    return true;
  }

  @Override
  public Boolean support(String code) {
    return "add".equals(code);
  }
}
