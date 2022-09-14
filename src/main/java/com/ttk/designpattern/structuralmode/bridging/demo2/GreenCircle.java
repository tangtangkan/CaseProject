package com.ttk.designpattern.structuralmode.bridging.demo2;

/**
 * 画绿圈
 */
public class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画绿圆, 半径: " + radius + ", x: " + x + ", y: " + y);
    }

}