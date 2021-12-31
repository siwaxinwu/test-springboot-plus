package com.roy.service.listen.email;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义EmailEvent
 * @description:
 * @author: Ding Yawu
 * @create: 2021-10-12 20:41
 */
public class EmailEvent extends ApplicationEvent {
    private String address;
    private String text;

    public EmailEvent(Object source, String address, String text){
        super(source);
        this.address = address;
        this.text = text;
    }

    public EmailEvent(Object source) {
        super(source);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
