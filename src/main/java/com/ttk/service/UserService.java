package com.ttk.service;

import com.ttk.entity.User;
import com.ttk.entity.request.AddUserRequest;
import com.ttk.entity.request.PageParams;
import com.ttk.entity.request.UserRequest;
import com.ttk.shiro.AccountProfile;
import com.ttk.utils.PageResult;


public interface UserService {

    int login(UserRequest userRequest);

    PageResult<User> selectAll(PageParams pageParams);

    User getById(Long userId);

    User getByLoginName(String loginName);

    Integer addorUpdateUser(AddUserRequest addUserRequest);

    User getUserInfo(Long uid);

    AccountProfile getCurrentLoginUser();

    Integer delUser(Long uid);

    void add1();

    void add2();

    void add3();

    void add4();

    void add5();

    void add6();

    void add7();

    void add8();

    void add9();

    void add10();

}
