package com.ttk.cese.designpattern.structuralmode.bridging.demo2;

/**
 * 画红圈
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画红圆, 半径: " + radius + ", x: " + x + ", y: " + y);
    }

}