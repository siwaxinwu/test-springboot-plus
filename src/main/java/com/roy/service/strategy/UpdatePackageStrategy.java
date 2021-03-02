package com.roy.service.strategy;

import com.roy.annotation.StrategyCode;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 15:03 2021-02-24
 */
@Component("update")
@StrategyCode(value = "update", name = "更新")
public class UpdatePackageStrategy extends PushStrategy {

  @Override
  public Boolean support(String code) {
    return "update".equals(code);
  }

  @Override
  public Boolean push(String applyNo) {
    return null;
  }
}
