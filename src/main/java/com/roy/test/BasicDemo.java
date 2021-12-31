package com.roy.test;

import com.roy.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/11/20 13:58
 */
@Component
public class BasicDemo {
    @Autowired
    private TestDemo testDemo;

    public String process(String data) {
        return Data.process(data);
    }

    private String show() {
        return testDemo.showCase();
    }

    String test() {
        return testDemo.testCase();
    }

    public enum Data {
        SHOW("show") {
            @Override
            String doProcess() {
                return SpringUtil.getBean(BasicDemo.class).show();
            }
        },
        CASE("test") {
            @Override
            String doProcess() {
                return SpringUtil.getBean(BasicDemo.class).test();
            }
        };

        private String data;

        Data(String data) {
            this.data = data;
        }

        abstract String doProcess();

        static String process(String data) {
            for (Data d: values()) {
                if (d.data.equalsIgnoreCase(data)) {
                    return d.doProcess();
                }
            }
            return null;
        }
    }
}
