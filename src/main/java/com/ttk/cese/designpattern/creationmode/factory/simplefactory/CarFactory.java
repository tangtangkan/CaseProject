package com.ttk.cese.designpattern.creationmode.factory.simplefactory;

/**
 * 汽车工厂
 */
public class CarFactory {

    public static CarProduct makeCar(String type) {

        switch (type) {
            case "Truck":
                return new TruckProduct();
            case "Passenger":
                return new PassengerCarProduct();
            default:
                return null;
        }

    }

}
