package com.ttk.test.designpattern.creationmode.builder.cs;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {

        showBike(new MobikeBuilder());
        showBike(new OfoBuilder());

    }

    private static void showBike(Builder builder) {
        Director director = new Director(builder);
        Bike bike = director.construct();
        System.out.println(bike.toString());

        // 将构建指挥类和构建者结合
        // Bike bike = builder.construct();
        // System.out.println(bike.toString());
    }

}
