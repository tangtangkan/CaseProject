package com.ttk.test.designpattern.structuralmode.facade.demo1;

/**
 * 正方形
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("正方形");
    }
}