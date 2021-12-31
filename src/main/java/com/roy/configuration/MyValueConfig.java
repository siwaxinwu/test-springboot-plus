package com.roy.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/6 22:44
 */
@Configuration
@ConfigurationProperties(prefix = "susan.test")
public class MyValueConfig {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
