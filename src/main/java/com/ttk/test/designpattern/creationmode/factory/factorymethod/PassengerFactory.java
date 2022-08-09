package com.ttk.test.designpattern.creationmode.factory.factorymethod;

public class PassengerFactory extends CarFactory{

    @Override
    CarProduct make() {
        return new PassengerCarProduct();
    }
}
