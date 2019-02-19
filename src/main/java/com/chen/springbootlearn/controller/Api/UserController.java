package com.chen.springbootlearn.controller.Api;

import com.chen.springbootlearn.annotation.LoginRequired;
import com.chen.springbootlearn.common.ApiResult;
import com.chen.springbootlearn.common.ErrorCode;
import com.chen.springbootlearn.controller.BaseController;
import com.chen.springbootlearn.domain.User;
import com.chen.springbootlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户列表
     */
    @GetMapping("/list")
    public ApiResult list() {
        return this.result(ErrorCode.SUCCESS, userService.findAll());
    }

    /**
     * 新增或修改用户
     */
    @PostMapping("/save")
    public ApiResult save(@ModelAttribute User user) {
        System.out.println(user.toString());
        return this.result(ErrorCode.SUCCESS, userService.save(user));
    }

    /**
     * 删除用户
     */
    @GetMapping("/delete/{id}")
    public ApiResult delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return this.result(ErrorCode.SUCCESS);
    }

    @LoginRequired
    @GetMapping("/find")
    public ApiResult findByName(@RequestParam("username") String username) {
        return this.result(ErrorCode.SUCCESS, userService.findByUsername(username));
    }

    @GetMapping("/find/{id}")
    public ApiResult findById(@PathVariable("id") Integer id) {
        return this.result(ErrorCode.SUCCESS, userService.findById(id));
    }
}
