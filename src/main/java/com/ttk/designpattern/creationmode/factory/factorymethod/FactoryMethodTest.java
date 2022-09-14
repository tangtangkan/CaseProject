package com.ttk.designpattern.creationmode.factory.factorymethod;

public class FactoryMethodTest {

    public static void main(String[] args) {
        PassengerFactory passengerFactory = new PassengerFactory();
        passengerFactory.make();

        TruckFactory truckFactory = new TruckFactory();
        truckFactory.make();

    }

}
