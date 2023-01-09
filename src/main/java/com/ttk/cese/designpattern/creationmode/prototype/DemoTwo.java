package com.ttk.cese.designpattern.creationmode.prototype;

import com.google.common.collect.Lists;

import java.util.List;

public class DemoTwo {

    public static void main(String[] args) {

        List<ShapeTwo> shapes = Lists.newArrayList();
        List<ShapeTwo> copyShapes = Lists.newArrayList();

        CircleTwo circle = new CircleTwo();
        circle.x = 10;
        circle.y = 20;
        circle.color = "red";
        circle.radius = 15;
        shapes.add(circle);

        CircleTwo circle1 = (CircleTwo)circle.clone();
        shapes.add(circle1);

        RectangleTwo rectangle = new RectangleTwo();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.width = 30;
        rectangle.heght = 40;
        shapes.add(rectangle);

        cloneAndCompare(shapes, copyShapes);

    }

    private static void cloneAndCompare(List<ShapeTwo> shapes, List<ShapeTwo> shapesCopy) {
        for (ShapeTwo shape : shapes) {
            shapesCopy.add((ShapeTwo)shape.clone());
        }

        for (ShapeTwo shape : shapesCopy) {
            System.out.println(shape);
        }

        System.out.println(shapesCopy.size());
    }

}
