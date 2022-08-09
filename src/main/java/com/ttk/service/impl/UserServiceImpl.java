package com.ttk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ttk.dao.UserDao;
import com.ttk.entity.User;
import com.ttk.entity.request.AddUserRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.entity.request.UserRequest;
import com.ttk.service.UserService;
import com.ttk.shiro.AccountProfile;
import com.ttk.utils.PageResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
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
}
