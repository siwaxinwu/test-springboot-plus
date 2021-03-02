package com.roy.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 13:43 2021-02-28
 */
// @Configuration
public class ThreadPoolConfig {

  @Value("${thread.pool.corePoolSize:5}")
  private int corePoolSize;

  @Value("${thread.pool.maxPoolSize:10}")
  private int maxPoolSize;

  @Value("${thread.pool.queueCapacity:200}")
  private int queueCapacity;

  @Value("${thread.pool.keepAliveSeconds:30}")
  private int keepAliveSeconds;

  @Value("${thread.pool.threadNamePrefix:ASYNC_}")
  private String threadNamePrefix;

  @Bean
  public Executor MessageExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setKeepAliveSeconds(keepAliveSeconds);
    executor.setThreadNamePrefix(threadNamePrefix);
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.initialize();
    return executor;
  }
}
