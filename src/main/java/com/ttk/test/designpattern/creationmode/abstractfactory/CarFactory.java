package com.ttk.test.designpattern.creationmode.abstractfactory;


/**
 * 汽车工厂
 */
public interface CarFactory {

    // 制造车
    CarProduct makeCar();

    // 制造轮胎
    TyreProduct makeTyre();

}
