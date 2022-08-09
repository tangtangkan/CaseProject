package com.ttk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttk.entity.User;
import com.ttk.entity.request.UserRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseMapper<User> {

    int login(@Param("param") UserRequest userRequest);

    List<User> selectAll();

    User getById(@Param("userId") Long userId);

    User getByLoginName(@Param("loginName") String loginName);

}
