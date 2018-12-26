package com.example.Exception;

import com.example.response.ResultCode;

/**
 * @author zhangzy
 * @email 120157229@qq.com
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
