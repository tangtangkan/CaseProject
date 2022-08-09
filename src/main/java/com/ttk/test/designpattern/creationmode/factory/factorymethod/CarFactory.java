package com.ttk.test.designpattern.creationmode.factory.factorymethod;

import com.ttk.test.designpattern.creationmode.factory.simplefactory.PassengerCarProduct;
import com.ttk.test.designpattern.creationmode.factory.simplefactory.TruckProduct;

/**
 * 汽车工厂
 */
public abstract class CarFactory {

    abstract CarProduct make();

}
