package com.roy.service.dealytest;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 16:31
 */

public class DelayMsg extends ApplicationEvent {
    private String msg;

    private String topic;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public DelayMsg(Object source, String msg, String topic) {
        super(source);
        this.msg = msg;
        this.topic = topic;
    }
}
