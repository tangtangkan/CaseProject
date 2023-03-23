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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
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

    @Override
    @Transactional
    public void add1() {
        User user = new User();
        user.setUserName("张三");
        userDao.insert(user);
    }

    @Override
    @Transactional
    public void add2() {
        User user = new User();
        user.setUserName("李四");
        userDao.insert(user);
    }

    @Override
    @Transactional
    public void add3() {
        User user = new User();
        user.setUserName("王五");
        userDao.insert(user);
        int a = 1/0;
    }

    @Override
    @Transactional
    public void add4() {
        add5();

        add6();
    }

    @Override
    public void add5() {
        User user = new User();
        user.setUserName("刘七");
        userDao.insert(user);
    }

    @Override
    public void add6() {
        User user = new User();
        user.setUserName("徐八");
        userDao.insert(user);
        int a = 1/0;
    }

    @Override
    // @Transactional
    public void add7() {
        add8();
        add9();
        add10();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add8() {
        User user = new User();
        user.setUserName("8");
        userDao.insert(user);
    }

    @Override
    @Transactional
    public void add9() {
        User user = new User();
        user.setUserName("9");
        userDao.insert(user);
        int a = 1/0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    // @Transactional
    public void add10() {
        User user = new User();
        user.setUserName("10");
        userDao.insert(user);
    }
}
