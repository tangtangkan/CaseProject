package com.ttk.designpattern.structuralmode.decorator.demo1;

/**
 * 形状装饰器
 */
public abstract class ShapeDecorator implements Shape {

    // 形状
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}