package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Pattern;

@Slf4j
public class JunitTest {

    @Test
    public void testFirst() {
        System.out.println("hello world!");
    }

    @Test
    public void testPhone() {
        try {
            checkPhone("15602227266");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 校验电话号码
     **/
    private void checkPhone(String phone) throws Exception {
        if (!Pattern.compile("^1[3|4|5|7|8|9][0-9]\\d{4,8}$").matcher(phone).matches()) {
            throw new Exception();
        }
    }
}
