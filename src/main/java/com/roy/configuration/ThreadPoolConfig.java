package com.roy.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 自定义线程池
 * @author dingyawu
 * @version 1.0
 * @date created in 13:43 2021-02-28
 */
@Configuration
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

  @Bean
  public ExecutorService emailTaskPool() {
    return new ThreadPoolExecutor(2, 4,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
  }

  @Bean
  public ScheduledThreadPoolExecutor  scheduledThreadPoolExecutor(){
    return new ScheduledThreadPoolExecutor(2, new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.setName("org.idea.threadpool.beat.sender");
        return thread;
      }
    });
  }




}
