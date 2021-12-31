package com.roy.controller;

import com.roy.dto.EmailDTO;
import com.roy.service.SendEmailService;
import com.roy.test.BasicDemo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 13:59
 */
@RestController
@Aspect
public class TestShowController {

    @Autowired
    private BasicDemo basicDemo;

    @GetMapping(path = "show")
    public String show(String data) {
        return basicDemo.process(data);
    }

    @Around("execution(public * com.roy.test.BasicDemo.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }


    @Resource
    private SendEmailService sendEmailService;

  @GetMapping(value = "/send-email")
  public boolean sendEmail() {
    EmailDTO emailDTO = new EmailDTO();
    emailDTO.setSubject("邮件标题");
    emailDTO.setBody("测试文案");
    emailDTO.setSender("idea");
    sendEmailService.sendEmail(emailDTO);
    return true;
  }
}
