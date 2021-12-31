package com.roy.dto;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/1 20:23
 */
public class HeartBeatInfo {
    private String info;
    private long nextSendTimeDelay;
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public long getNextSendTimeDelay() {
        return nextSendTimeDelay;
    }
    public void setNextSendTimeDelay(long nextSendTimeDelay) {
        this.nextSendTimeDelay = nextSendTimeDelay;
    }
    @Override
    public String toString() {
        return "HeartBeatInfo{" +
                "info='" + info + '\'' +
                ", nextSendTimeDelay=" + nextSendTimeDelay +
                '}';
    }
}
