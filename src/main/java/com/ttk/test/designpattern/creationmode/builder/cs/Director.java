package com.ttk.test.designpattern.creationmode.builder.cs;

/**
 * 指挥者类
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        builder.builderRim();
        return builder.createBike();
    }

}
