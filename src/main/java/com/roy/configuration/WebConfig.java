package com.roy.configuration;

import com.roy.filter.LogCostFilter;
import com.roy.interceptor.FangshuaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 22:38 2021-01-16
 * @history:
 */
@Configuration
@EnableWebMvc
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

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new IPAddressArgumentResolver());
		resolvers.add(new CurrentUserNameHandlerMethodArgumentResolver());
	}

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }
}
