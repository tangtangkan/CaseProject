package com.ttk.examplecase.designpattern.creationmode.abstractfactory;

/**
 * 客车工厂
 */
public class PassengerFactory implements CarFactory {

    @Override
    public CarProduct makeCar() {
        System.out.println("制造客车");
        return new TruckProduct();
    }

    @Override
    public TyreProduct makeTyre() {
        System.out.println("制造客车轮胎");
        return new TruckTyreProduct();
    }
}
