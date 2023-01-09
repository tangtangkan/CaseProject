package com.ttk.cese.designpattern.creationmode.abstractfactory;


public class AbstractFactoryTest {
    public static void main(String[] args) {

        // 货车工厂
        TruckFactory truckFactory = new TruckFactory();
        truckFactory.makeCar();
        truckFactory.makeTyre();

        System.out.println();

        // 客车工厂
        PassengerFactory passengerFactory = new PassengerFactory();
        passengerFactory.makeCar();
        passengerFactory.makeTyre();

    }
}
