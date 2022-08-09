package com.ttk.controller;

import com.authzuser.AuthzUserService;
import com.ttk.entity.User;
import com.ttk.shiro.JwtToken;
import com.ttk.shiro.JwtUtils;
import com.ttk.utils.CommonResult;
import com.ttk.entity.request.UserRequest;
import com.ttk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final JwtUtils jwtUtils;

    private final AuthzUserService authzUserService;

    @Autowired
    public AdminController (UserService userService, JwtUtils jwtUtils, AuthzUserService authzUserService) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.authzUserService = authzUserService;
    }

    // @RequiresAuthentication
    @CrossOrigin
    @RequestMapping("/login")
    @PostMapping
    public CommonResult<String> login(@RequestBody UserRequest userRequest, HttpServletResponse response) {
        User user = userService.getByLoginName(userRequest.getLoginName());

        if (user== null || !user.getPassWord().equals(userRequest.getPassWord())) {
            return new CommonResult<>("用户或密码错误");
        }

        // 生成jwt
        String jwt = jwtUtils.generateToken(user.getLoginName(), user.getUid());

        // 登录
        SecurityUtils.getSubject().login(new JwtToken(jwt));

        // response.setHeader("Authorization", jwt);
        // response.setHeader("Access-Control-Expose-Headers", "Authorization");

        return new CommonResult<>(200, "登录成功", user.getLoginName(), jwt);
    }

    // 退出
    @RequiresAuthentication
    @GetMapping("/logout")
    public CommonResult logout() {
        // SecurityUtils.getSubject().logout();
        return CommonResult.success("退出成功", null);
    }

    @GetMapping("/authzuser")
    public CommonResult authzuser() {
        authzUserService.test();
        return CommonResult.success("", null);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        Map<String, Object> map = new HashMap<>();
        map.put("1", "we");
        map.put("2", "we");
        map.put("3", "we");
        map.put("4", "we");
        String str = map.keySet().stream().collect(Collectors.joining(","));
        System.out.println(str);
    }

}
