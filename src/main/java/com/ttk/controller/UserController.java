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

    /**
     * 全部回滚（第一个异常后代码不会往下执行）
     * @return
     */
    @PostMapping ("/addOne")
    public CommonResult addOne() {
        userService.addOne();
        return CommonResult.success("请求成功");
    }

    /**
     * 全部回滚（第一个异常后代码不会往下执行）
     * @return
     */
    @PostMapping ("/addTwo")
    public CommonResult addTwo() {
        userService.addTwo();
        return CommonResult.success("请求成功");
    }

    /**
     * blog保存成功（记录日志开了一个新的事务，在执行完毕之后，已经提交）
     * message_record失败（回滚，因为blog保存是新开的事务，所以不会回滚）
     * @return
     */
    @PostMapping ("/addThree")
    public CommonResult addThree() {
        userService.addThree();
        return CommonResult.success("请求成功");
    }

    /**
     * blog保存成功
     * message_record失败
     * @return
     */
    @PostMapping ("/addFour")
    public CommonResult addFour() {
        userService.addFour();
        return CommonResult.success("请求成功");
    }

    /**
     * 全部回滚（第一个异常后代码不会往下执行）
     * @return
     */
    @PostMapping ("/addFive")
    public CommonResult addFive() {
        userService.addFive();
        return CommonResult.success("请求成功");
    }

    /**
     * 全部回滚（使用的是同一个事务）
     * @return
     */
    @PostMapping ("/addSix")
    public CommonResult addSix() {
        userService.addSix();
        return CommonResult.success("请求成功");
    }

}
