package com.ttk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ttk.entity.Blog;

public interface BlogDao extends BaseMapper<Blog> {

    IPage<Blog> pageBlog(IPage<Blog> page);

}
