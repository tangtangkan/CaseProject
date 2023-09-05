package com.ttk.examplecase.designpattern.creationmode.builder.cs;

/**
 * (具体构建类)
 * 摩拜单车Builder类
 */
public class MobikeBuilder extends Builder {

    @Override
    public void buildFrame() {
        mBike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("真皮车座");
    }

    @Override
    public void builderRim() {
        mBike.setRim("铁篮筐");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}