package com.roy.service;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:39 2021-02-28
 */
@Service
public class MyFactoryBean implements FactoryBean {
  @Override
  public Object getObject() throws Exception {
    return "ok";
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
