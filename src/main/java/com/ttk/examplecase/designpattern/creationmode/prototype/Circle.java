package com.ttk.examplecase.designpattern.creationmode.prototype;

/**
 * 圆
 */
public class Circle extends Shape{

    // 半径
    public int radius;

    public Circle() {
    }

    public Circle(Circle circle) {
        if (circle != null) {
            this.radius = circle.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }
}
