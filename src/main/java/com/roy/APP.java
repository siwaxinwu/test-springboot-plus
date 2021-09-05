package com.roy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description： author：dingyawu date：created in 22:08 2020/11/21 history: (exclude =
 * DataSourceAutoConfiguration.class)
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class APP {
  public static void main(String[] args) {
    SpringApplication.run(APP.class, args);
  }
}
