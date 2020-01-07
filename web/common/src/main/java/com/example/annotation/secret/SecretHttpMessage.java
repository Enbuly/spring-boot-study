package com.example.annotation.secret;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.InputStream;

/**
 * http请求
 *
 * @author lazy cat
 * @since 2020-01-08
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SecretHttpMessage implements HttpInputMessage {

    private InputStream body;

    private HttpHeaders httpHeaders;

    @Override
    public InputStream getBody() {
        return this.body;
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.httpHeaders;
    }
}
