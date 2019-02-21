package com.chen.springbootlearn.exception.handle;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.common.LocaleMessage;
import com.chen.springbootlearn.exception.CustomAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final LocaleMessage localeMessage;

    @Autowired
    public GlobalExceptionHandler(LocaleMessage localeMessage) {
        this.localeMessage = localeMessage;
    }

    @ExceptionHandler(CustomAuthException.class)
    @ResponseBody
    public ApiResult handleCustomAuthException(CustomAuthException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        return new ApiResult(errorCode.getCode(), localeMessage.getMessage(errorCode.getMsgKey()), exception.getData());
    }
}
