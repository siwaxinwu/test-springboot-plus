package com.roy.annotation;

import java.lang.annotation.*;

/**
 * IP注解
 * @author dingyawu
 * @version 1.0
 * @date created in 22:17 2021-03-17
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface IP {

	String name() default "ip";

	boolean required() default true;

	String defaultValue() default "0";
}
