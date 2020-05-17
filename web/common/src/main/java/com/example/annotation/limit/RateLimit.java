package com.example.annotation.limit;

import java.lang.annotation.*;

/**
 * RateLimit
 *
 * @author lazy cat
 * 2020-05-17
 **/
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {

    String limitKey();

    String limitCount() default "5";
}
