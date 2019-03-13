package com.example.exception;

import com.example.response.ResultCode;

/**
 * @author zhangzy
 * @since 12-26
 **/
public class ParamsCheckException extends BaseRuntimeException {

    public ParamsCheckException(ResultCode resultCode) {
        super(resultCode);
    }

    public ParamsCheckException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }
}
