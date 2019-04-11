package com.example.exception;

import com.example.response.ResultCode;

/**
 * @author zhangzhenyan
 * @since  2019-04-11
 **/
public class ParamsCheckException extends BaseRuntimeException {

    public ParamsCheckException(ResultCode resultCode) {
        super(resultCode);
    }

    public ParamsCheckException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }
}
