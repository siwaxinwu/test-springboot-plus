package com.roy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 23:18 2021-02-03
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {

  int seconds();

  int maxCount();

  boolean needLogin() default true;
}
