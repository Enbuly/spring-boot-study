package com.example.exception;


import com.example.constant.ResultCode;

/**
 * 服务层异常
 *
 * @author cat
 * @since 2019-04-11
 **/
public class ServiceException extends BaseRuntimeException {

    public ServiceException(ResultCode resultCode) {
        super(resultCode);
    }
}
