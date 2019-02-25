package com.chen.springbootlearn.controller;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import org.apache.shiro.ShiroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 */
@RestControllerAdvice
public class ExceptionController {

    private final ApiResult apiResult;

    @Autowired
    public ExceptionController(ApiResult apiResult) {
        this.apiResult = apiResult;
    }

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public ApiResult handle401() {
        return apiResult.result(ErrorCode.ACCESS_FAIL);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public ApiResult globalException(HttpServletRequest request, Throwable ex) {
        return apiResult.result(ErrorCode.UNKNOW_ERROR);
    }
}
