package com.roy.service;

import com.roy.configuration.MyValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @description: 测试@value基本的用法,演示默认值的设置
 * @author: Ding Yawu
 * @create: 2021/11/6 22:39
 */
@Service
public class AService {

    @Value("${susan.test.userName:dingyawu}")
    private String userName;

    //@value这个地方同样也可以注入bean的，通过这种方式，可以注入id为roleService的bean
    @Value("#{myValueConfig}")
    private MyValueConfig myValueConfig;

    @Value("${susan.test.array:1,2,3,4,5}")
    private int[] array;

    @Value("#{'${susan.test.list}'.split(',')}")
    private List<String> list;

    //@Value("#{'${susan.test.set:}'.empty ? null : '${susan.test.set:}'.split(',')}") 演示默认值为空
    @Value("#{'${susan.test.set}'.split(',')}")
    private Set<String> set;

    public String test() {
        System.out.println(userName);
        return userName;
    }

    public String testMyValueConfig() {
        return myValueConfig.getUserName();
    }

    public String testSetAndList() {
        System.out.println(list);
        System.out.println(set);
        return "ok";

    }
}
