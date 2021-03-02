package com.roy.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 22:21 2021-01-16
 * @history:
 */
@Service
public class MyFactoryBeanService implements BeanFactoryAware {
  private BeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  public void test() {
    Object myFactoryBean = beanFactory.getBean("myFactoryBean");
    System.out.println(myFactoryBean);
    Object myFactoryBean1 = beanFactory.getBean("&myFactoryBean");
    System.out.println(myFactoryBean1);
  }
}
