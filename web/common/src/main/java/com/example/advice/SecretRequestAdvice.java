package com.example.advice;

import com.example.annotation.secret.SecretBody;
import com.example.annotation.secret.SecretHttpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * 拦截需要解密的请求。
 * 注意：post请求且有@RequestBody注解才能拦截
 *
 * @author lazy cat
 * @since 2020-01-08
 **/
@RestControllerAdvice
@ConditionalOnProperty(prefix = "faster.secret", name = "enabled", havingValue = "true")
public class SecretRequestAdvice implements RequestBodyAdvice {

    private Logger log = LoggerFactory.getLogger(SecretRequestAdvice.class);

    //检查方法上是否存在SecretBody注解，存在即解密，否则不处理
    private boolean supportSecretRequest(MethodParameter parameter) {
        if (null != parameter.getMethod()) {
            return parameter.getMethod().isAnnotationPresent(SecretBody.class);
        }
        return false;
    }

    //模拟解密
    private String decryptBody(HttpInputMessage inputMessage) throws IOException {
        InputStream encryptStream = inputMessage.getBody();
        log.info("模拟解密...");
        return StreamUtils.copyToString(encryptStream, Charset.defaultCharset());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        boolean supportSafeMessage = supportSecretRequest(parameter);

        String httpBody;
        if (supportSafeMessage) {
            httpBody = decryptBody(inputMessage);
        } else {
            httpBody = StreamUtils.copyToString(inputMessage.getBody(), Charset.defaultCharset());
        }

        return new SecretHttpMessage(new ByteArrayInputStream(httpBody.getBytes()), inputMessage.getHeaders());
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}
