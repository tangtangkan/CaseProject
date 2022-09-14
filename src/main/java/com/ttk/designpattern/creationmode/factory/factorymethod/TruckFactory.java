package com.ttk.designpattern.creationmode.factory.factorymethod;

public class TruckFactory extends CarFactory{

    @Override
    CarProduct make() {
        return new TruckProduct();
    }
}
