package com.ttk.test.designpattern.creationmode.prototype;

import com.google.common.collect.Lists;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Shape> shapes = Lists.newArrayList();
        List<Shape> copyShapes = Lists.newArrayList();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.color = "red";
        circle.radius = 15;
        shapes.add(circle);

        Circle circle1 = (Circle)circle.clone();
        shapes.add(circle1);

        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.width = 30;
        rectangle.heght = 40;
        shapes.add(rectangle);

        cloneAndCompare(shapes, copyShapes);

    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (Shape shape : shapesCopy) {
            System.out.println(shape);
        }

        System.out.println(shapesCopy.size());
    }

}
