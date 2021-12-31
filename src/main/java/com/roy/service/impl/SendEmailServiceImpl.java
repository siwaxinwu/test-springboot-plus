package com.roy.service.impl;

import com.roy.configuration.ThreadPoolConfig;
import com.roy.dto.EmailDTO;
import com.roy.service.SendEmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/1 20:16
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {
    @Resource
    private ExecutorService emailTaskPool;

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        emailTaskPool.submit(() -> {
            try {
                System.out.printf("sending email .... emailDto is %s \n", emailDTO);
                Thread.sleep(1000);
                System.out.println("sended success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
