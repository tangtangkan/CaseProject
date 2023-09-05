package com.ttk.examplecase.designpattern.creationmode.abstractfactory;

/**
 * 货车工厂
 */
public class TruckFactory implements CarFactory {

    @Override
    public CarProduct makeCar() {
        System.out.println("制造货车");
        return new TruckProduct();
    }

    @Override
    public TyreProduct makeTyre() {
        System.out.println("制造货车轮胎");
        return new TruckTyreProduct();
    }
}
