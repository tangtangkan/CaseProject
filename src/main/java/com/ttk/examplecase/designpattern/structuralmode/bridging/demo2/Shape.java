package com.ttk.examplecase.designpattern.structuralmode.bridging.demo2;

/**
 * 形状
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}