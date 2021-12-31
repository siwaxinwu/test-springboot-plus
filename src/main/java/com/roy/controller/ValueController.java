package com.roy.controller;

import com.roy.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/6 22:41
 */
@RestController
public class ValueController {

    @Autowired
    private AService aService;

    /**
     * 测试@value的基本用法
     *
     * @return {@link String}
     */
    @RequestMapping("/test/value")
    public String testValue(){
        return aService.test();
    }

    /**
     * 测试MyValueConfig来注入value的案例
     *
     * @return {@link String}
     */
    @RequestMapping("/test/myvalueconfig")
    public String testValue1(){
        return aService.testMyValueConfig();
    }

    @RequestMapping("/test/setlist")
    public String testsetlist(){
        return aService.testSetAndList();
    }
}
