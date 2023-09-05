package com.ttk.examplecase.designpattern.creationmode.factory.simplefactory;

/**
 * 客车
 */
public class PassengerCarProduct extends CarProduct {

    public PassengerCarProduct() {
        System.out.println("制造客车");
    }

    @Override
    protected void driveCar() {
        System.out.println("开客车");
    }
}
