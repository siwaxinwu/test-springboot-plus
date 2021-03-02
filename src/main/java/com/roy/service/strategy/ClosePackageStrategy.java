package com.roy.service.strategy;

import com.roy.annotation.StrategyCode;
import org.springframework.stereotype.Component;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 15:02 2021-02-24
 */
@Component("close")
@StrategyCode(value = "close", name = "关闭")
public class ClosePackageStrategy extends PushStrategy {
  @Override
  public Boolean push(String applyNo) {
    return null;
  }

  @Override
  public Boolean support(String code) {
    return "close".equals(code);
  }
}
