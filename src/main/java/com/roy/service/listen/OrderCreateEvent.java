package com.roy.service.listen;

import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 订单创建活动事件
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 7:45
 * @Description
 */
public class OrderCreateEvent extends ApplicationEvent {
    private String name;

    //消息参数
    private List<String> contentList;

    public OrderCreateEvent(Object source, String name, List<String> contentList) {
        super(source);
        this.name = name;
        this.contentList = contentList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getContentList() {
        return contentList;
    }
    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }
}
