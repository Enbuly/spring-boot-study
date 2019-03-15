package com.example.test;

import com.example.api.UserService;
import com.example.mapper.UserMapper;
import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("redisCacheTemplate")
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void testFirst() {
        System.out.println(userService.getPassword("zzy"));
    }

    @Test
    public void testSecond() {
        System.out.println(userMapper.selectPasswordByUserName("zzy"));
    }

    @Test
    public void redisTest() {
        String key = StringUtils.join(new String[]{"user", "token"}, ":");
        String value = "0171826834da554b43d2c72bb1767c7898f27bf91775463e2b3b4e0f3806e0255d6e52ca286b";
        stringRedisTemplate.opsForValue().set(key, value);
        System.out.println(stringRedisTemplate.opsForValue().get(key));

        User user = new User();
        user.setName("Tom");
        user.setPassword(value);

        String userKey = StringUtils.join(new String[]{"user", "model"}, ":");
        redisCacheTemplate.opsForValue().set(userKey, user);
        System.out.println(redisCacheTemplate.opsForValue().get(userKey));
    }
}
