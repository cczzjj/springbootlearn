package com.chen.springbootlearn.exception;

public class CommonException extends RuntimeException {
    public CommonException(Integer code, String message) {
        super(message);
    }
}
