package com.example.config;

import com.example.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * filter 配置
 *
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
@SuppressWarnings("unchecked")
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean securityFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(securityFilterBean());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("AuthFilter");
        return registrationBean;
    }

    @Bean
    public Filter securityFilterBean() {
        return new AuthFilter();
    }

}
