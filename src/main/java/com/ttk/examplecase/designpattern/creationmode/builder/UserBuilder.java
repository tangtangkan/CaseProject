package com.ttk.examplecase.designpattern.creationmode.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造器实现
 */
public class UserBuilder implements IUserBuilder {

    private String days;

    public UserBuilder(String days) {
        this.days = days;
    }

    @Override
    public String buildNicaname() {
        String nicaname = "赫连小伍";
        System.out.println("查询用户昵称为：" + nicaname);
        return nicaname;
    }

    @Override
    public int buildPayCnt() {
        int payCnt = 0;
        if ("30".equals(days)) {
            payCnt = 1;
        } else {
            payCnt = 10;
        }
        System.out.println("查询用户近" + days + "天的消费笔数为：" + payCnt);
        return payCnt;
    }

    @Override
    public int buildPayAmt() {
        int payAmt = 0;
        if ("30".equals(days)) {
            payAmt = 2;
        } else {
            payAmt = 100;
        }
        System.out.println("查询用户近" + days + "天的消费金额为：" + payAmt);
        return payAmt;
    }

    @Override
    public List buildProductType() {
        List list = new ArrayList<>();
        list.add("增发剂");
        list.add("格子衫");
        System.out.println("查询用户浏览的商品类型为：" + list);
        return list;
    }

    @Override
    public List buildAmtInterval() {
        List list = new ArrayList<>();
        list.add("1-9");
        list.add("2-10");
        System.out.println("查询用户浏览的商品价格区间为：" + list);
        return list;
    }

    @Override
    public User getUser() {
        User user = new User();
        user.setNickname(this.buildNicaname());
        user.setPayCnt(this.buildPayCnt());
        user.setPayAmt(this.buildPayAmt());
        user.setProductType(this.buildProductType());
        user.setAmtInterval(this.buildAmtInterval());
        return user;
    }
}