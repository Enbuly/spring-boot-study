package com.example.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 通用响应VO
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 */
public class ResultVo<T> implements Serializable {

    @ApiModelProperty(value = "响应码，对应ResultCode中的code")
    private String code;

    @ApiModelProperty(value = "响应消息，对应ResultCode中的msg")
    private String message = "";

    @ApiModelProperty(value = "响应数据")
    private T data;

    private ResultVo(String code) {
        this.code = code;
    }

    private ResultVo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResultVo(String code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResultVo(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ResultVo success(String message) {
        return new ResultVo(ResultCode.SUCCESS.getCode(), message);
    }

    public static <T> ResultVo<T> success(T data, String message) {
        return new ResultVo<>(ResultCode.SUCCESS.getCode(), data, message);
    }

    public static ResultVo error(String message) {
        return new ResultVo(ResultCode.ERROR.getCode(), message);
    }

    public static ResultVo create(String code, String message) {
        return new ResultVo(code, message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
