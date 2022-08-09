package com.ttk.dao;


/**
 * extends BaseMapper<T>：继承接口即可实现基本的CRUD方法
 * <p>
 * 1.如果自定义的mapper继承了mybatis-plus的BaseMapper时，xxxMapper.xml中不可以包含insert方法，因为在BaseMapper中存在该方法
 * 2.如果对应的xxxMapper.xml中包含insert方法，那么就会执行xxxMapper.xml中的方法，相当于重写BaseMapper中的insert方法；
 * 如果xxxMapper.xml中没有insert方法，默认使用BaseMapper中的方法
 * 3.注意：BaseMapper<T>中的泛型对应相应的实体类
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttk.entity.MessageRecord;

/**
 * @author Administrator
 */

public interface MessageRecordMapper extends BaseMapper<MessageRecord> {

}
