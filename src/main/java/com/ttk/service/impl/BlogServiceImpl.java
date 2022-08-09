package com.ttk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ttk.dao.BlogDao;
import com.ttk.entity.Blog;
import com.ttk.entity.request.BlogRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.service.BlogService;
import com.ttk.shiro.AccountProfile;
import com.ttk.utils.PageResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogDao blogDao;

    @Autowired
    public BlogServiceImpl (BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public static void main(String[] args) {
        String a = "{\"user_id\":[11111111111, 1200000001, 1200000001]}";
        JSONObject jsonObject = JSONObject.parseObject(a);
        Long user_id = (Long)jsonObject.getJSONArray("user_id").get(0);
        System.out.println(user_id);
    }

    @Override
    public int addorUpdateBlog(BlogRequest blogRequest) {

        AccountProfile accountProfile = (AccountProfile)SecurityUtils.getSubject().getPrincipal();

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogRequest, blog);
        blog.setCreateDate(new Date());
        blog.setUpdateDate(new Date());
        if (blog.getId() == null) {
            blog.setCreateId(accountProfile.getId());
        }
        blog.setUpdateId(accountProfile.getId());
        return blog.getId() == null ? blogDao.insert(blog) : blogDao.updateById(blog);
    }

    @Override
    public PageResult<Blog> pageBlog(PageParams pageParams) {

        Page<Blog> page = new Page<>(pageParams.getPage(), pageParams.getSize());

        // 单表分页查询
        // IPage<Blog> userIPage = blogDao.selectPage(page, new LambdaQueryWrapper<>());
        // 多表分页查询
        IPage<Blog> userIPage = blogDao.pageBlog(page);

        return new PageResult<>(userIPage.getTotal(), userIPage.getSize(), userIPage.getPages(), userIPage.getRecords());
    }

    @Override
    public Blog getBlogInfo(Long id) {
        return blogDao.selectById(id);
    }
}
