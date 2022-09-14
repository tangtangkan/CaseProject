package com.ttk.designpattern.creationmode.factory.simplefactory;

public class SimpleFactoryTest {

    public static void main(String[] args) {

        // 汽车工厂实例
        CarProduct truck = CarFactory.makeCar("Truck");
        truck.driveCar();

        CarProduct passenger = CarFactory.makeCar("Passenger");
        passenger.driveCar();

    }

}
