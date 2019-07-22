//package com.example.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Redis集群配置
// *
// * @author lazy cat
// * @since 2019-07-23
// */
//@Configuration
//public class RedisFactoryConfig {
//
//    @Resource
//    private Environment environment;
//
//    @Bean
//    public RedisConnectionFactory myLettuceConnectionFactory() {
//        Map<String, Object> source = new HashMap<>();
//        source.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
//        source.put("spring.redis.cluster.max-redirects", environment.getProperty("spring.redis.cluster.max-redirects"));
//        RedisClusterConfiguration redisClusterConfiguration;
//        redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
//        return new LettuceConnectionFactory(redisClusterConfiguration);
//    }
//}
