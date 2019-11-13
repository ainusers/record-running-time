package com.analysis.ainusers.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: tianyong
 * @date: 2019/11/12 13:52
 * @desciption:记录方法运行时间 (自定义注解)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Record {
}