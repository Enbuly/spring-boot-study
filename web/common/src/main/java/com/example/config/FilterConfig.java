package com.example.config;

import com.example.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * filter 配置
 *
 * @author zhangzy
 * @since 3-7
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean securityFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(securityFilterBean());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("AuthFilter");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public Filter securityFilterBean() {
        return new AuthFilter();
    }

}
