package com.roy.service;

import com.roy.dto.EmailDTO;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/1 19:53
 */
public interface SendEmailService {
    /**
     * 发送邮件
     *
     * @param emailDTO 邮件对象
     */
    void sendEmail(EmailDTO emailDTO);
}