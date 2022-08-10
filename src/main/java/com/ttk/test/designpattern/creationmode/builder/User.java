package com.ttk.test.designpattern.creationmode.builder;

import java.util.List;

/**
 * 实体
 *
 * 精准营销（时间：半年）
 *      用户昵称
 *      支付次数
 *      支付金额
 *
 * 刺激消费（时间：一个月）
 *      用户昵称
 *      商品类型
 *      价格区间
 */
public class User {

    // 昵称
    private String nickname;

    // 消费次数
    private int payCnt;

    // 消费金额
    private int payAmt;

    // 浏览商品类型
    private List productType;

    // 浏览商品价格区间
    private List amtInterval;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPayCnt(int payCnt) {
        this.payCnt = payCnt;
    }

    public void setPayAmt(int payAmt) {
        this.payAmt = payAmt;
    }

    public void setProductType(List<String> productType) {
        this.productType = productType;
    }

    public void setAmtInterval(List<String> amtInterval) {
        this.amtInterval = amtInterval;
    }

}
