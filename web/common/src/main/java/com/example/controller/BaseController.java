package com.example.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.constant.ResultCode;
import com.example.exception.ParamsCheckException;
import com.example.requestVo.PageRequestVo;

/**
 * 基础controller
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
public class BaseController {

    void checkToken(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new ParamsCheckException(ResultCode.PARAMETER_ERROR);
        }
    }

    void checkName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new ParamsCheckException(ResultCode.PARAMETER_ERROR);
        }
    }

    void checkPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            throw new ParamsCheckException(ResultCode.PARAMETER_ERROR);
        }
    }

    void checkPageRequestVo(PageRequestVo pageRequestVo) {
        if (pageRequestVo.getCurrentPage() <= 0) {
            throw new ParamsCheckException(ResultCode.PARAMETER_ERROR);
        }
        if (pageRequestVo.getPageSize() <= 0) {
            throw new ParamsCheckException(ResultCode.PARAMETER_ERROR);
        }
    }
}
