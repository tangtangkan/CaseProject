package com.ttk.designpattern.structuralmode.decorator.demo1;

/**
 * 长方形
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("画长方形");
    }
}