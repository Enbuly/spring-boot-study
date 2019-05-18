1、pom.xml加入redis依赖。
    <!--redis-->
    <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
	<dependency> <!--lettuce连接池的配置依赖-->
		<groupId>org.apache.commons</groupId>
		<artifactId>commons-pool2</artifactId>
	</dependency>
	
2、加入redis配置。
@Configuration
public class LettuceRedisConfig {

    @Autowired
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

3、application.yml加入
spring:
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

4、启动本地redis服务。

5、测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJunitTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("redisCacheTemplate")
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Test
    public void redisTest() {
        String key = "123";
        String value = "0171826834da554b43d2c72bb1767c7898f27bf91775463e2b3b4e0f3806e0255d6e52ca286b";
        stringRedisTemplate.opsForValue().set(key, value);
        System.out.println(stringRedisTemplate.opsForValue().get(key));

        User user = new User();
        user.setName("Tom");
        user.setPassword(value);

        String userKey = "456";
        redisCacheTemplate.opsForValue().set(userKey, user);
        System.out.println(redisCacheTemplate.opsForValue().get(userKey));
    }
}

测试前加入model：
/**
 * @author zhangzy
 * @since 11-21
 * @email 120157229@qq.com
 * **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private double salary;
    private int status;
    private String phone;
    private String password;
}