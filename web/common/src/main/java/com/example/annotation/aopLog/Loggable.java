package com.example.annotation.aopLog;

import java.lang.annotation.*;

/**
 * 输出日志自定义注解
 *
 * @author lazy cat
 * @since 2019-09-26
 **/
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

    /**
     * 是否输出日志
     */
    boolean loggable();
}
