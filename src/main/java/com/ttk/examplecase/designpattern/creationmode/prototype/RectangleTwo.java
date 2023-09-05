package com.ttk.examplecase.designpattern.creationmode.prototype;

/**
 * 长方形
 */
public class RectangleTwo extends ShapeTwo{

    public int width;

    public int heght;

    public RectangleTwo() {
    }

    public RectangleTwo(RectangleTwo rectangle) {
        if (rectangle != null) {
            this.width = rectangle.width;
            this.heght = rectangle.heght;
        }
    }
}
