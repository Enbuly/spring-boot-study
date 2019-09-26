package com.example.annotation.checkArgs;

import java.lang.annotation.*;

/**
 * int/Integer最小值校验
 *
 * @author zhangzhenyan
 * @since 2019-09-24
 **/
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckArgMin {

    /**
     * int/Integer最小值校验
     **/
    int min();
}
