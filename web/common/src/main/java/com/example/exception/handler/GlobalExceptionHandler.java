package com.example.exception.handler;

import com.example.exception.BaseException;
import com.example.exception.BaseRuntimeException;
import com.example.responseVo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 *
 * @author lazy cat
 * @since 2019-04-11
 */
@Slf4j
@RestController
@ControllerAdvice("com.example.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseRuntimeException.class)
    public ResultVo defaultBaseRuntimeExceptionHandler(HttpServletRequest request, BaseRuntimeException ex) {
        log.error("BaseRuntimeException Handler---Host {} invoke url {} ERROR: {}", request.getRemoteHost(), request.getRequestURL(), ex);
        return ResultVo.create(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(value = BaseException.class)
    public ResultVo defaultBaseExceptionHandler(HttpServletRequest request, BaseException ex) {
        log.error("BaseException Handler---Host {} invoke url {} ERROR: {}", request.getRemoteHost(), request.getRequestURL(), ex);
        return ResultVo.create(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVo defaultExceptionHandler(HttpServletRequest request, Exception ex) {
        log.error("DefaultException Handler---Host {} invoke url {} ERROR: {}", request.getRemoteHost(), request.getRequestURL(), ex);
        return ResultVo.error("system busy");
    }

}
