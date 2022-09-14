package com.ttk.designpattern.structuralmode.facade.demo1;

/**
 * 圆形
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("圆形");
    }
}