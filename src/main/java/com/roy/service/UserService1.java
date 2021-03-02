package com.roy.service;

import com.roy.entity.User;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 17:35 2021-01-16
 * @history:
 */
@Service
public class UserService1 {

  public User createUser() {
    return new User() {
      {
        setId("1");
        setName("dingyawu");
      }
    };
  }
}
