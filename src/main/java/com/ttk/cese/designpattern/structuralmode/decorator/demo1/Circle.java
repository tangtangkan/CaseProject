package com.ttk.cese.designpattern.structuralmode.decorator.demo1;

/**
 * 圆圈
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("画圆圈");
    }
}