package com.ttk.designpattern.creationmode.prototype;

/**
 * 抽象图形类
 */
// public abstract class ShapeTwo implements Cloneable{
public abstract class ShapeTwo {

    public int x;

    public int y;

    public String color;

    public ShapeTwo() {
    }

    public ShapeTwo(ShapeTwo shape) {
        if (shape != null) {
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    // public abstract ShapeTwo clone();

    // @Override
    public Object clone () {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
