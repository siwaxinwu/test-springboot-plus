package com.roy.service;

import java.lang.annotation.*;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021-09-27 18:08
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimitAspect {

}

