package com.example.config;

import com.example.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 3-7
 **/
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new AuthFilter());
        registration.addUrlPatterns("/*");
        registration.setName("AuthFilter");
        return registration;
    }
}
