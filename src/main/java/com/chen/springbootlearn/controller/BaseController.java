package com.chen.springbootlearn.controller;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.common.LocaleMessage;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected LocaleMessage localeMessage;

    protected ApiResult result(ErrorCode errorCode) {
        return new ApiResult(errorCode, localeMessage.getMessage(errorCode.getMsgKey()));
    }

    protected ApiResult result(ErrorCode errorCode, Object data) {
        return new ApiResult(errorCode, localeMessage.getMessage(errorCode.getMsgKey()), data);
    }

}
