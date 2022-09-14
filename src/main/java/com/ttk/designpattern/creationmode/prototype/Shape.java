package com.ttk.designpattern.creationmode.prototype;

/**
 * 抽象图形类
 */
public abstract class Shape {

    public int x;

    public int y;

    public String color;

    public Shape() {
    }

    public Shape(Shape shape) {
        if (shape != null) {
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    public abstract Shape clone();
}
