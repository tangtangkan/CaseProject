package com.ttk.controller;

import com.alibaba.fastjson.JSON;
import com.ttk.entity.Blog;
import com.ttk.entity.request.BlogRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.service.BlogService;
import com.ttk.shiro.AccountProfile;
import com.ttk.utils.CommonResult;
import com.ttk.utils.PageResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequiresAuthentication
    @PostMapping("/addorUpdateBlog")
    public CommonResult<Integer> addorUpdateBlog(@RequestBody BlogRequest blogRequest) {
        return CommonResult.success("请求成功", blogService.addorUpdateBlog(blogRequest));
    }

    @RequiresAuthentication
    @PostMapping("/pageBlog")
    public CommonResult<PageResult<Blog>> pageBlog(@RequestBody PageParams pageParams) {
        PageResult<Blog> userPageResult = blogService.pageBlog(pageParams);
        return CommonResult.success("请求成功", userPageResult);
    }

    @RequiresAuthentication
    @GetMapping("/getBlogInfo")
    public CommonResult<Blog> getBlogInfo(@RequestParam(value = "id") Long id) {
        return CommonResult.success("请求成功", blogService.getBlogInfo(id));
    }

    @RequiresAuthentication
    @GetMapping("/test")
    public CommonResult test() {
        AccountProfile accountProfile = (AccountProfile)SecurityUtils.getSubject().getPrincipal();
        // System.out.println(JSON.toJSONString(accountProfile));
        return CommonResult.success("请求成功", null);
    }

}
