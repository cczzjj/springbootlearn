package com.chen.springbootlearn.controller;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.common.LocaleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

public class BaseController {
    @Autowired
    protected LocaleMessage localeMessage;

    public ApiResult result(ErrorCode errorCode) {
        return new ApiResult(errorCode, localeMessage.getMessage(errorCode.getMsgKey()));
    }

    public ApiResult result(ErrorCode errorCode, Object data) {
        return new ApiResult(errorCode, localeMessage.getMessage(errorCode.getMsgKey()), data);
    }

}
