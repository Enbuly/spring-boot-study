1、将log4j-dev.xml拷贝到resources目录下。
2、common项目pom增加
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j</artifactId>
    </dependency>
3、application.yml文件增加
logging:
    config: classpath:log4j-dev.xml