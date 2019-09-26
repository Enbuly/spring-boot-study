package com.example.annotation.checkArgs;


import java.lang.annotation.*;

/**
 * 字符串判空校验
 *
 * @author zhangzhenyan
 * @since 2019-09-24
 **/
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckArgIsEmpty {

    /**
     * 字符串判空校验
     **/
    boolean isEmpty();
}
