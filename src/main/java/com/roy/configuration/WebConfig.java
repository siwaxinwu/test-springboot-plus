package com.roy.configuration;

import com.roy.interceptor.FangshuaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 22:38 2021-01-16
 * @history:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired private FangshuaInterceptor interceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor);
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new DateConverter());
  }
}
