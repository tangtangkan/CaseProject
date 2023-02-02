package com.ttk.controller;

import com.ttk.service.AsyncService;
import com.ttk.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试@Async注解
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    private final AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/test")
    public CommonResult<Object> test() {
        asyncService.test();
        return CommonResult.success("请求成功");
    }

}
