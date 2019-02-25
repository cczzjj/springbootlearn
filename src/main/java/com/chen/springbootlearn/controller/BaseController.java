package com.chen.springbootlearn.controller;

import com.chen.springbootlearn.common.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected ApiResult apiResult;
}
