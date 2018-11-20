package com.example.test;

import com.example.api.UserService;
import com.example.mapper.UserMapping;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapping userMapping;

    @Test
    public void testFirst() {
        System.out.println(userService.getPassword("zzy"));
    }

    @Test
    public void testSecond() {
        System.out.println(userMapping.selectPasswordByUserName("zzy"));
    }
}
