package com.roy;

import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description： author：dingyawu date：created in 22:08 2020/11/21 history: (exclude =
 * DataSourceAutoConfiguration.class)
 * SpringBoot 1.x版本中的默认本地cache是Guava Cache。
 * 在2.x（Spring Boot 2.0(spring 5) ）版本中已经用Caffine Cache取代了Guava Cache。毕竟有了更优的缓存淘汰策略。
 */
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, RedissonAutoConfiguration.class})
//@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
@EnableCaching
public class APP {
  public static void main(String[] args) {
    SpringApplication.run(APP.class, args);
  }
}
