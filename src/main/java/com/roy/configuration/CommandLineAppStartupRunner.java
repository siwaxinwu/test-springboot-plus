package com.roy.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * 如果我们的项目使用的是 Spring Boot，那么可以使用 Spring Boot 提供的 CommandLineRunner
 * 接口来实现初始化逻辑，Spring Boot 将在启动初始化完成之后调用实现了CommandLineRunner的接口的run方法：
 * @author dingyawu
 * @version 1.0
 * @date created in 8:25 2021-03-26
 */
@Component
@Slf4j
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Override
	public void run(String...args) throws Exception {
		log.info("Increment counter");
	}
}
