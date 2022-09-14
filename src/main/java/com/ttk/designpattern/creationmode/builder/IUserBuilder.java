package com.ttk.designpattern.creationmode.builder;

import java.util.List;

/**
 * 构造器接口
 */
public interface IUserBuilder {

    // 构建用户昵称
    String buildNicaname();

    // 构建用户消费次数，days代表最近天数
    int buildPayCnt();

    // 构建用户消费金额，days代表最近天数
    int buildPayAmt();

    // 构建用户经常浏览商品类型
    List buildProductType();

    // 构建用户经常浏览商品价格区间
    List buildAmtInterval();

    // 获取user对象
    User getUser();
}
