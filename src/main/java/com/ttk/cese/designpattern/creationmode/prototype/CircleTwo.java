package com.ttk.cese.designpattern.creationmode.prototype;

/**
 * ε
 */
public class CircleTwo extends ShapeTwo{

    // εεΎ
    public int radius;

    public CircleTwo() {
    }

    public CircleTwo(CircleTwo circle) {
        if (circle != null) {
            this.radius = circle.radius;
        }
    }
}
