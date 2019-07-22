redis集群集成：
pom.xml:
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-redis</artifactId>
   </dependency>
   <dependency><!--lettuce连接池的配置依赖-->
       <groupId>org.apache.commons</groupId>
       <artifactId>commons-pool2</artifactId>
   </dependency>
1、添加RedisFactoryConfig代码。
2、添加LettuceRedisConfig（跟单个redis配置一样）
3、在配置文件添加如下
spring:
  redis:
    cluster:
      nodes: 127.0.0.1:7000,127.0.0.1:7001,127.0.0.1:7002,127.0.0.1:7003,127.0.0.1:7004,127.0.0.1:7005
      max-redirects: 3

跟单个redis配置区别：
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
