package com.chen.springbootlearn.controller;

import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.mapper.UserMapper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {
    private final UserMapper userMapper;

    @Autowired
    public AdminController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public ApiResult getUser() {
        List<String> list = userMapper.getUser();
        return apiResult.result(ErrorCode.USER_UNEXIST);
//        return apiResult.success(list);
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
    @RequiresRoles("admin")
    public ApiResult banUser(String username) {
        userMapper.banUser(username);
        return apiResult.success();
//        return resultMap.success().code(200).message("成功封号！");
    }
}
