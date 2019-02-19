package com.chen.springbootlearn.controller;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;

public class BaseController {
    public ApiResult result(ErrorCode errorCode, Object data) {
        return new ApiResult(errorCode, data);
    }

    public ApiResult result(ErrorCode errorCode) {
        return new ApiResult(errorCode, null);
    }

}
