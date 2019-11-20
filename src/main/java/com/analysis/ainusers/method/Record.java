package com.analysis.ainusers.method;

import java.lang.annotation.*;

/**
 * @author: tianyong
 * @date: 2019/11/12 13:52
 * @desciption:记录方法运行时间 (自定义注解)
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Record {
}