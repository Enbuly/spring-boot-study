//package com.example.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * RedissonConfig
// *
// * @author lazy cat
// * @since 2019-07-23
// */
//@Configuration
//public class RedissonConfig {
//
//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useClusterServers()
//                .setScanInterval(2000)
//                .addNodeAddress("127.0.0.1:7000")
//                .addNodeAddress("127.0.0.1:7001")
//                .addNodeAddress("127.0.0.1:7002")
//                .addNodeAddress("127.0.0.1:7003")
//                .addNodeAddress("127.0.0.1:7004")
//                .addNodeAddress("127.0.0.1:7005");
//        return Redisson.create(config);
//    }
//}
