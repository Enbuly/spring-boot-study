package com.example.exception;


import com.example.constant.ResultCode;

/**
 * 服务层异常
 *
 * @author zhangzhenyan
 * @since  2019-04-11
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
