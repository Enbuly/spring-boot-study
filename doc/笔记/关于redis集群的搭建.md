## mac搭建redis集群
1、cd redis
2、mkdir 7000 7001 7002 7003 7004
3、将redis.conf拷贝到各个创建的文件夹下。
4、修改各个redis.conf
(1)端口号，每个目录都不同
port 700X
(2)开启集群模式
cluster-enabled yes
(3)节点超时实际，单位毫秒
cluster-node-timeout 5000
(4)集群内部配置文件(默认为 nodes.conf)
cluster-config-file nodes-6379.conf(原来的redis.conf配置打开此配置即可)
(5)启动 AOF
appendonly yes
5、然后cd到各个文件夹目录下依次运行：redis-server redis.conf
6、关联所有节
redis-cli -p 7000
127.0.0.1:7000> cluster meet 127.0.0.1 7001
OK
127.0.0.1:7000> cluster meet 127.0.0.1 7002
OK
127.0.0.1:7000> cluster meet 127.0.0.1 7003
OK
127.0.0.1:7000> cluster meet 127.0.0.1 7004
OK
127.0.0.1:7000> cluster meet 127.0.0.1 7005
7、分配slot
redis-cli -p 7000 cluster addslots {0..5461}
redis-cli -p 7001 cluster addslots {5462..10922}
redis-cli -p 7002 cluster addslots {10923..16383}
8、redis-cli -p 7000 cluster nodes查看是否分配好
9、主从复制
redis-cli -p 7003 cluster replicate 7000的NodeID
redis-cli -p 7004 cluster replicate 7001的NodeID
redis-cli -p 7005 cluster replicate 7002的NodeID
备注：这个 7000的NodeID 7001的NodeID 7002的NodeID 其实就是执行
redis-cli -p 7000 cluster nodes 命令出现的那一串 16 进制字符串。
10、redis-cli -p 7000 cluster nodes查看是否分配好

## spring boot redis集群集成：

1、往pom.xml添加如下:
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-redis</artifactId>
   </dependency>
   <dependency><!--lettuce连接池的配置依赖-->
       <groupId>org.apache.commons</groupId>
       <artifactId>commons-pool2</artifactId>
   </dependency>

2、添加RedisFactoryConfig代码。

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Redis集群配置
 *
 * @author lazy cat
 * @since 2019-07-23
 */
@Configuration
public class RedisFactoryConfig {

    @Resource
    private Environment environment;

    @Bean
    public RedisConnectionFactory myLettuceConnectionFactory() {
        Map<String, Object> source = new HashMap<>();
        source.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
        source.put("spring.redis.cluster.max-redirects", environment.getProperty("spring.redis.cluster.max-redirects"));
        RedisClusterConfiguration redisClusterConfiguration;
        redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
        return new LettuceConnectionFactory(redisClusterConfiguration);
    }
}

3、添加LettuceRedisConfig（跟单个redis配置一样）

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * RedisLettuce配置
 *
 * @author lazy cat
 * @since 2018-12-28
 */
@SuppressWarnings("unchecked")
@Configuration
public class LettuceRedisConfig {

    @Resource
    private LettuceConnectionFactory lettuceConnectionFactory;

    @Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate() {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}

4、在配置文件添加如下
spring:
  redis:
    cluster:
      nodes: 127.0.0.1:7000,127.0.0.1:7001,127.0.0.1:7002,127.0.0.1:7003,127.0.0.1:7004,127.0.0.1:7005
      max-redirects: 3

集群redis跟单个redis配置区别：
1、配置区别
  #redis集群（集群时要先注释单个redis下的配置，并确保本地运行了redis集群）
  redis:
    cluster:
      nodes: 127.0.0.1:7000,127.0.0.1:7001,127.0.0.1:7002,127.0.0.1:7003,127.0.0.1:7004,127.0.0.1:7005
      max-redirects: 3

  #单个redis
  redis:
    host: localhost
    database: 1
    port: 6379
    ssl: false
    timeout:
    lettuce:
      pool:
        min-idle: 3
        max-idle: 5
        max-wait: 60000ms
        max-active: 10
2、集群需要添加配置类

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Redis集群配置
 *
 * @author lazy cat
 * @since 2019-07-23
 */
@Configuration
public class RedisFactoryConfig {

    @Resource
    private Environment environment;

    @Bean
    public RedisConnectionFactory myLettuceConnectionFactory() {
        Map<String, Object> source = new HashMap<>();
        source.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
        source.put("spring.redis.cluster.max-redirects", environment.getProperty("spring.redis.cluster.max-redirects"));
        RedisClusterConfiguration redisClusterConfiguration;
        redisClusterConfiguration = new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
        return new LettuceConnectionFactory(redisClusterConfiguration);
    }
}
