package com.chen.springbootlearn.controller.api;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController extends BaseController {

    @GetMapping("/welcome")
    public ApiResult login() {
        return apiResult.result(ErrorCode.WELCOME);
    }
}
