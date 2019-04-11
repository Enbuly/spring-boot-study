package com.example.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 通用响应VO
 *
 * @author zhangzhenyan
 * @Since 2019-04-11
 */
public class ResultVo<T> implements Serializable {

    @ApiModelProperty(value = "响应码，对应ResultCode中的code")
    private String code;

    @ApiModelProperty(value = "响应消息，对应ResultCode中的msg")
    private String msg = "";

    @ApiModelProperty(value = "响应数据")
    private T data;

    private ResultVo(String code) {
        this.code = code;
    }

    private ResultVo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultVo(String code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResultVo(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static ResultVo<Void> success() {
        return new ResultVo<Void>(ResultCode.SUCCESS.code());
    }

    public static ResultVo<Void> success(String msg) {
        return new ResultVo<Void>(ResultCode.SUCCESS.code(), msg);
    }

    public static <T> ResultVo<T> success(T data) {
        return new ResultVo<T>(ResultCode.SUCCESS.code(), data);
    }

    public static <T> ResultVo<T> success(T data, String msg) {
        return new ResultVo<T>(ResultCode.SUCCESS.code(), data, msg);
    }

    public static ResultVo<Void> failure() {
        return new ResultVo<Void>(ResultCode.ERROR.code());
    }

    public static ResultVo<Void> failure(String msg) {
        return new ResultVo<Void>(ResultCode.ERROR.code(), msg);
    }

    public static <T> ResultVo<T> failure(T data) {
        return new ResultVo<T>(ResultCode.ERROR.code(), data);
    }

    public static <T> ResultVo<T> failure(T data, String msg) {
        return new ResultVo<T>(ResultCode.ERROR.code(), data, msg);
    }

    public static ResultVo<Void> failure(ResultCode resultCode) {
        return new ResultVo<Void>(resultCode.code(), resultCode.msg());
    }

    public static <T> ResultVo<T> failure(ResultCode resultCode, T data) {
        return new ResultVo<T>(resultCode.code(), data, resultCode.msg());
    }

    public static ResultVo<Void> create(String code) {
        return new ResultVo<Void>(code);
    }

    public static ResultVo<Void> create(String code, String msg) {
        return new ResultVo<Void>(code, msg);
    }

    public static <T> ResultVo<T> create(String code, T data) {
        return new ResultVo<T>(code, data);
    }

    public static <T> ResultVo<T> create(String code, T data, String msg) {
        return new ResultVo<T>(code, data, msg);
    }

    public static ResultVo<Void> create(ResultCode resultCode) {
        return new ResultVo<Void>(resultCode.code(), resultCode.msg());
    }

    public static <T> ResultVo<T> create(ResultCode resultCode, T data) {
        return new ResultVo<T>(resultCode.code(), data, resultCode.msg());
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}
