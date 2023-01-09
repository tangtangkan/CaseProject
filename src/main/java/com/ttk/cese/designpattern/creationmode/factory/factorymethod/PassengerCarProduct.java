package com.ttk.cese.designpattern.creationmode.factory.factorymethod;


/**
 * 客车
 */
public class PassengerCarProduct extends CarProduct {

    public PassengerCarProduct() {
        System.out.println("制造客车");
    }

    @Override
    public void driveCar() {
        System.out.println("开客车");
    }
}
