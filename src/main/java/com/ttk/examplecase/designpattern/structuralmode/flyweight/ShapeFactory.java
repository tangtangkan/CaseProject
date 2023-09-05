package com.ttk.examplecase.designpattern.structuralmode.flyweight;

import java.util.HashMap;

public class ShapeFactory {

    // key: 颜色, value: 圆形
    protected static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {

        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("创建带颜色的圆: " + color);
        }
        return circle;

    }
}