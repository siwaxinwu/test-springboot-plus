package com.roy.service.dealytest;

import org.springframework.context.event.EventListener;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener
public @interface Consumer {
    String topic();
}
