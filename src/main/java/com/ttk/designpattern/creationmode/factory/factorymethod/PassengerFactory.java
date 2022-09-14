package com.ttk.designpattern.creationmode.factory.factorymethod;

public class PassengerFactory extends CarFactory{

    @Override
    CarProduct make() {
        return new PassengerCarProduct();
    }
}
