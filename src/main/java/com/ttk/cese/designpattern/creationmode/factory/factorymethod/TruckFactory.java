package com.ttk.cese.designpattern.creationmode.factory.factorymethod;

public class TruckFactory extends CarFactory{

    @Override
    CarProduct make() {
        return new TruckProduct();
    }
}
