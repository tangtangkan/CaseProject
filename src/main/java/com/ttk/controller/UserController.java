package com.ttk.controller;

import cn.hutool.crypto.SecureUtil;
import com.ttk.entity.User;
import com.ttk.entity.request.AddUserRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.service.UserService;
import com.ttk.utils.CommonResult;
import com.ttk.utils.PageResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 初始密码
    private static String PWD = "123456";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequiresAuthentication
    @PostMapping("/selectAll")
    public CommonResult<PageResult<User>> selectAll(@RequestBody PageParams pageParams) {
        PageResult<User> userPageResult = userService.selectAll(pageParams);
        return CommonResult.success("请求成功", userPageResult);
    }

    @RequiresAuthentication
    @PostMapping("/addorUpdateUser")
    public CommonResult<Integer> addorUpdateUser(@RequestBody AddUserRequest addUserRequest) {
        addUserRequest.setPassWord(SecureUtil.md5(PWD));
        return CommonResult.success("请求成功", userService.addorUpdateUser(addUserRequest));
    }

    @RequiresAuthentication
    @GetMapping("/getUserInfo")
    public CommonResult<User> getUserInfo(@RequestParam(value = "uid") Long uid) {
        return CommonResult.success("请求成功", userService.getUserInfo(uid));
    }

    @RequiresAuthentication
    @PostMapping ("/delUser")
    public CommonResult<Integer> delUser(@RequestBody Map<String, Long> map) {
        return CommonResult.success("请求成功", userService.delUser(map.get("uid")));
    }

    @PostMapping ("/addOne")
    public CommonResult addOne() {
        userService.add1();
        userService.add2();
        userService.add3();
        return CommonResult.success("请求成功");
    }

    @PostMapping ("/addTwo")
    public CommonResult addTwo() {
        userService.add4();
        return CommonResult.success("请求成功");
    }

    @PostMapping ("/addThree")
    public CommonResult addThree() {
        userService.add7();

        // userService.add8();
        // userService.add10();
        // userService.add9();
        return CommonResult.success("请求成功");
    }

}
