package com.example.annotation;

/**
 * 测试
 *
 * @author zhangzhenyan
 * @since 2019-09-24
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUsername("zzy");
        user.setAge(20);
        System.out.println(ValidatorResolver.validate(user));
    }
}
