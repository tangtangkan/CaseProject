package com.ttk.test.designpattern.creationmode.prototype;

/**
 * 长方形
 */
public class Rectangle extends Shape{

    public int width;

    public int heght;

    public Rectangle() {
    }

    public Rectangle(Rectangle rectangle) {
        if (rectangle != null) {
            this.width = rectangle.width;
            this.heght = rectangle.heght;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}
