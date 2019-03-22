package com.example.exception;


import com.example.response.ResultCode;

/**
 * @author zhangzy
 * @since 12-26
 **/
public class ServiceException extends BaseRuntimeException {
    public ServiceException(ResultCode resultCode) {
        super(resultCode);
    }

    public ServiceException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public ServiceException() {
        super(ResultCode.ERROR);
    }
}