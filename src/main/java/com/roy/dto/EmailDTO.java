package com.roy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/1 19:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO {
    private String subject;
    private String recipient;
    private String body;
    private String attachment;
    private String cc;
    private String bcc;
    private String sender;
}
