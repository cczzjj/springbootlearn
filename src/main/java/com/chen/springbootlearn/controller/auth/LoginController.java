package com.chen.springbootlearn.controller.auth;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.controller.BaseController;
import com.chen.springbootlearn.mapper.UserMapper;
import com.chen.springbootlearn.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {
    private final UserMapper userMapper;

    @Autowired
    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ApiResult login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        String realPassword = userMapper.getPassword(username);
        if (realPassword == null || !realPassword.equals(password)) {
            return apiResult.result(ErrorCode.USER_AUTH_ERROR);
        } else {
            return apiResult.result(ErrorCode.LOGIN_SUCCESS, JWTUtil.createToken(username));
        }
    }
}
