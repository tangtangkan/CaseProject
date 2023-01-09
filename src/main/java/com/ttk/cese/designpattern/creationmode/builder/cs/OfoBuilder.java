package com.ttk.cese.designpattern.creationmode.builder.cs;

/**
 * （具体构建类）
 * ofo单车Builder类
 */
public class OfoBuilder extends Builder {

    @Override
    public void buildFrame() {
        mBike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        mBike.setSeat("橡胶车座");
    }

    @Override
    public void builderRim() {
        mBike.setRim("铝合金篮筐");
    }

    @Override
    public Bike createBike() {
        return mBike;
    }
}