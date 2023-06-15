package com.ttk.service;

import com.ttk.entity.Blog;
import com.ttk.entity.request.BlogRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.utils.PageResult;

public interface BlogService {

    int addorUpdateBlog(BlogRequest blogRequest);

    PageResult<Blog> pageBlog(PageParams pageParams);

    Blog getBlogInfo(Long id);

    /**
     * 不加@Transactional注解
     */
    void addBlog1(Blog blog);

    /**
     * @Transactional
     */
    void addBlog2(Blog blog);

    /**
     * @Transactional(propagation = Propagation.REQUIRES_NEW)
     */
    void addBlog3(Blog blog);

}
