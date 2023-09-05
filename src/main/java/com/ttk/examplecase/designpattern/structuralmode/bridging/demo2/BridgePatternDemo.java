package com.ttk.examplecase.designpattern.structuralmode.bridging.demo2;

/**
 * Demo
 */
public class BridgePatternDemo {

    public static void main(String[] args) {

        // // 画红圆
        // Shape redCircle = new Circle(10, 10, 10, new RedCircle());
        //
        // // 画绿圆
        // Shape greenCircle = new Circle(100, 100, 100, new GreenCircle());
        //
        // redCircle.draw();
        //
        // greenCircle.draw();


        RedCircle redCircle = new RedCircle();
        redCircle.drawCircle(10, 10, 10);

        GreenCircle greenCircle = new GreenCircle();
        greenCircle.drawCircle(100, 100, 100);

    }

}