package com.ttk.examplecase.designpattern.creationmode.factory.simplefactory;

/**
 * 货车
 */
public class TruckProduct extends CarProduct{

    public TruckProduct() {
        System.out.println("制造货车");
    }

    @Override
    public void driveCar() {
        System.out.println("开货车");
    }
}
