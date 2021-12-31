package com.roy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *ApplicationRunner的实现类
 *  --version=2.1.0 aaa bbb ccc
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-12 21:27
 */

@Component
@Slf4j
public class CustomApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("控制台接收的参数：{},{},{}",args.getOptionNames(),args.getNonOptionArgs(),args.getSourceArgs());
    }
}
