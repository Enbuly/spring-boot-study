package com.example.test;

import com.example.api.UserService;
import com.example.mapper.BatchMapper;
import com.example.mapper.UserMapper;
import com.example.model.Batch;
import com.example.model.User;
import com.example.request.SelectPasswordRequestVo;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
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
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJunitTest {

    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private BatchMapper batchMapper;

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

    @Test
    public void testDao() {
        String password = userMapper.selectPasswordByUserNameSecond(new SelectPasswordRequestVo("zzy", "15602227266"));
        if (password != null) {
            System.out.println(password);
        }
    }

    @Test
    public void testRedisCluster() {
        ArrayList<RedisURI> list = new ArrayList<>();
        list.add(RedisURI.create("redis://127.0.0.1:7000"));
        list.add(RedisURI.create("redis://127.0.0.1:7001"));
        list.add(RedisURI.create("redis://127.0.0.1:7002"));
        list.add(RedisURI.create("redis://127.0.0.1:7003"));
        list.add(RedisURI.create("redis://127.0.0.1:7004"));
        list.add(RedisURI.create("redis://127.0.0.1:7005"));
        RedisClusterClient client = RedisClusterClient.create(list);
        StatefulRedisClusterConnection<String, String> connect = client.connect();
        RedisAdvancedClusterCommands<String, String> commands = connect.sync();
        //commands.set("test2","zzy");
        String str = commands.get("test2");
        System.out.println(str);
        connect.close();
        client.shutdown();
    }

    @Test
    public void testBatchInsert() {
        List<Batch> list = new ArrayList<>();
        list.add(new Batch("1", "zzy", "13828831312"));
        list.add(new Batch("2", "zzx", "15602227266"));
        batchMapper.batchInsert(list);
    }

}
