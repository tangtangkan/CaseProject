package com.ttk.designpattern.structuralmode.decorator.demo1;

/**
 * 红色形状装饰器
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    /**
     * 设置红色边框
     * @param decoratedShape
     */
    private void setRedBorder(Shape decoratedShape) {
        System.out.println("设置红色边框");
    }
}