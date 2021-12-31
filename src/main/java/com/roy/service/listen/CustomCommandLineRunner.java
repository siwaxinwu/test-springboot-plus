package com.roy.service.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 自定义CommandLineRunner，可以从控制台接受参数
 * java -jar demo.jar aaa bbb ccc program arguments：aaa bbb ccc
 * 不同的CommandLineRunner实现可以通过@Order()指定执行顺序
 *
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-12 21:11
 */
@Component
@Slf4j
public class CustomCommandLineRunner implements CommandLineRunner {

    /**
     * @param args 接收控制台传入的参数
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("从控制台接收参数>>>>"+ Arrays.asList(args));
    }
}
