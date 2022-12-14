package com.ttk.cese.designpattern.creationmode.prototype;

/**
 * ε
 */
public class Circle extends Shape{

    // εεΎ
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
