package com.ttk.cese.designpattern.creationmode.prototype;

/**
 * 圆
 */
public class CircleTwo extends ShapeTwo{

    // 半径
    public int radius;

    public CircleTwo() {
    }

    public CircleTwo(CircleTwo circle) {
        if (circle != null) {
            this.radius = circle.radius;
        }
    }
}
