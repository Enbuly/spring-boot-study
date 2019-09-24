package com.example.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * model
 *
 * @author zhangzhenyan
 * @since 2019-09-24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @CheckArgIsEmpty(isEmpty = false)
    private String username;

    @CheckArgMax(max = 120)
    @CheckArgMin(min = 1)
    private int age;
}
