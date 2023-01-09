package com.ttk.cese.designpattern.structuralmode.facade.demo1;

/**
 * 长方形
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("长方形");
    }
}