package com.ttk.test.designpattern.creationmode.builder.cs;

import lombok.Data;

/**
 * （产品）
 * 自行车类
 */
@Data
public class Bike {

    // 车架
    private String frame;

    // 车座
    private String seat;

    private String rim;

    @Override
    public String toString() {
        return "Bike{" +
                "frame='" + frame + '\'' +
                ", seat='" + seat + '\'' +
                ", rim='" + rim + '\'' +
                '}';
    }
}