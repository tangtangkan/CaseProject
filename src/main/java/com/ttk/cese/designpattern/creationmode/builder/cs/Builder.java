package com.ttk.cese.designpattern.creationmode.builder.cs;

/**
 * （构建类）
 * 抽象 builder 类
 */
public abstract class Builder {

    protected Bike mBike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract void builderRim();

    public abstract Bike createBike();

    // 将构建指挥类和构建者结合
    // public Bike construct() {
    //     this.buildFrame();
    //     this.buildSeat();
    //     this.builderRim();
    //     return this.createBike();
    // }
}