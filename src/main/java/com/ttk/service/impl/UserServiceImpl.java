package com.ttk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ttk.dao.UserDao;
import com.ttk.entity.Blog;
import com.ttk.entity.MessageRecord;
import com.ttk.entity.User;
import com.ttk.entity.request.AddUserRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.entity.request.UserRequest;
import com.ttk.service.BlogService;
import com.ttk.service.MessageRecordService;
import com.ttk.service.UserService;
import com.ttk.shiro.AccountProfile;
import com.ttk.utils.PageResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final BlogService blogService;

    private final MessageRecordService messageRecordService;

    @Autowired
    public UserServiceImpl(UserDao userDao, BlogService blogService, MessageRecordService messageRecordService) {
        this.userDao = userDao;
        this.blogService = blogService;
        this.messageRecordService = messageRecordService;
    }

    @Override
    public int login(UserRequest userRequest) {
        return userDao.login(userRequest);
    }

    public PageResult<User> selectAll(PageParams pageParams) {
        Page<User> page = new Page<>(pageParams.getPage(), pageParams.getSize());
        IPage<User> userIPage = userDao.selectPage(page, new LambdaQueryWrapper<>());
        return new PageResult<>(userIPage.getTotal(), userIPage.getSize(), userIPage.getPages(), userIPage.getRecords());
    }

    @Override
    public User getById(Long userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getByLoginName(String loginName) {
        return userDao.getByLoginName(loginName);
    }

    @Override
    public Integer addorUpdateUser(AddUserRequest addUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest, user);
        return user.getUid() == null ? userDao.insert(user) : userDao.updateById(user);
    }

    @Override
    public User getUserInfo(Long uid) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        // 不查询pass_word字段
        queryWrapper.select(User.class, info -> !info.getColumn().equals("pass_word"));
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public AccountProfile getCurrentLoginUser() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

    @Override
    public Integer delUser(Long uid) {
        return userDao.deleteById(uid);
    }

    @Override
    @Transactional
    public void addOne() {
        Blog blog = new Blog();
        blog.setTitle("标题");
        blog.setCreateId(10l);

        // 异常
        blog.setCreateId(1l);

        blogService.addBlog2(blog);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setFromUser("用户1");
        messageRecord.setRoomId(20l);
        messageRecordService.addMessageRecord2(messageRecord);

    }

    @Override
    @Transactional
    public void addTwo() {
        Blog blog = new Blog();
        blog.setTitle("标题");
        blog.setCreateId(10l);

        // 异常
        blog.setCreateId(1l);

        blogService.addBlog3(blog);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setFromUser("用户1");
        messageRecord.setRoomId(20l);
        messageRecordService.addMessageRecord2(messageRecord);
    }

    @Override
    @Transactional
    public void addThree() {
        Blog blog = new Blog();
        blog.setTitle("标题");
        blog.setCreateId(10l);
        blogService.addBlog3(blog);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setFromUser("用户1");
        messageRecord.setRoomId(20l);

        // 异常
        messageRecord.setRoomId(1l);

        messageRecordService.addMessageRecord2(messageRecord);
    }

    @Override
    @Transactional
    public void addFour() {
        Blog blog = new Blog();
        blog.setTitle("标题");
        blog.setCreateId(10l);
        blogService.addBlog3(blog);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setFromUser("用户1");
        messageRecord.setRoomId(20l);

        // 异常
        messageRecord.setRoomId(1l);

        messageRecordService.addMessageRecord3(messageRecord);
    }

    @Override
    @Transactional
    public void addFive() {
        Blog blog = new Blog();
        blog.setTitle("标题");
        blog.setCreateId(10l);

        // 异常
        blog.setCreateId(1l);

        blogService.addBlog3(blog);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setFromUser("用户1");
        messageRecord.setRoomId(20l);
        messageRecordService.addMessageRecord3(messageRecord);
    }

    @Override
    @Transactional
    public void addSix() {
        Blog blog = new Blog();
        blog.setTitle("标题");
        blog.setCreateId(10l);
        blogService.addBlog2(blog);

        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setFromUser("用户1");
        messageRecord.setRoomId(20l);

        // 异常
        messageRecord.setRoomId(1l);

        messageRecordService.addMessageRecord2(messageRecord);
    }
}
