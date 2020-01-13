package com.example.annotation.secret;

import java.lang.annotation.*;

/**
 * 加密解密http请求
 *
 * @author lazy cat
 * @since 2020-01-07
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Inherited
public @interface SecretBody {
}
