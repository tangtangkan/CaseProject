package com.ttk.service;

import com.ttk.entity.Blog;
import com.ttk.entity.request.BlogRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.utils.PageResult;

public interface BlogService {

    int addorUpdateBlog(BlogRequest blogRequest);

    PageResult<Blog> pageBlog(PageParams pageParams);

    Blog getBlogInfo(Long id);

}
