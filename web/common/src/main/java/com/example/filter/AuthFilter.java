package com.example.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 用户验证过滤器
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
@Component
public class AuthFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (StringUtils.substring(request.getRequestURI(), 0, 11).equals("/springboot")) {

            String token = request.getHeader("token");

            if (StringUtils.isEmpty(token)) {
                returnJson(response);
            } else {
                String userName = stringRedisTemplate.opsForValue().get(token);
                if (!StringUtils.isEmpty(userName)) {
                    try {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } catch (ServletException | IOException e) {
                        log.info(e.getMessage());
                    }
                } else {
                    returnJson(response);
                }
            }
        } else {
            try {
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (ServletException | IOException e) {
                log.info(e.getMessage());
            }
        }
    }

    private void returnJson(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            OutputStream out = response.getOutputStream();
            out.write("token is not exist!".getBytes());
            out.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("come to filter! method init-");
    }

    @Override
    public void destroy() {
        log.info("come to filter! method destroy-");
    }
}
