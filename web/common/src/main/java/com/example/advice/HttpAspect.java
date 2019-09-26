package com.example.advice;

import com.example.annotation.aopLog.Loggable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * controller advice
 *
 * @author lazy cat
 * @since 2019-06-13
 **/
@Aspect
@Component
public class HttpAspect {

    private Logger log = LoggerFactory.getLogger(HttpAspect.class);

    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        }
        return ip;
    }

    @Pointcut("execution(public * com.example.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void daBefore() {

    }

    @AfterReturning(pointcut = "log()")
    public void doAfter() {
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {

        //目标方法实体
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        boolean hasMethodLogAnno = method
                .isAnnotationPresent(Loggable.class);
        //没加注解 直接执行返回结果
        if (!hasMethodLogAnno) {
            return point.proceed();
        }

        handleRequestLog(point);
        Object result = point.proceed();
        handleResponseLog(result);
        return result;
    }

    private void handleRequestLog(JoinPoint joinPoint) throws Exception {

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            throw new Exception("日志输出异常，请检查HttpAspect");
        }

        HttpServletRequest request = attributes.getRequest();
        Object[] objects = joinPoint.getArgs();
        log.info("请求的url地址为:{}", getIpAddress(request));
        log.info("请求的路径为:{}", request.getRequestURI());
        log.info("请求的方法为:{}", request.getMethod());
        log.info("请求的参数为:{}", objects);
    }

    private void handleResponseLog(Object object) {
        if (object != null) {
            log.info("响应数据:{}", object);
        }
    }

}
