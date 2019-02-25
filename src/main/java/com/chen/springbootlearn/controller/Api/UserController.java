//package com.chen.springbootlearn.controller.Api;
//
//import com.chen.springbootlearn.annotation.LoginRequired;
//import com.chen.springbootlearn.common.ApiResult;
//import com.chen.springbootlearn.common.ErrorCode;
//import com.chen.springbootlearn.controller.BaseController;
//import com.chen.springbootlearn.domain.SysUser;
//import com.chen.springbootlearn.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class UserController extends BaseController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    /**
//     * 查询所有用户列表
//     */
//    @GetMapping("/list")
//    public ApiResult list() {
//        return this.result(ErrorCode.SUCCESS, null);
//    }
//}
