package com.chen.springbootlearn.exception.handle;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.exception.CustomAuthException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomAuthException.class)
    @ResponseBody
    public ApiResult handleCustomAuthException(CustomAuthException exception) {
        return new ApiResult(exception.getErrorCode(), exception.getData());
    }
}
