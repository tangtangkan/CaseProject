package com.ttk.cese.designpattern.structuralmode.decorator.demo1;

public class DecoratorPatternDemo {

    public static void main(String[] args) {

        Shape circle = new Circle();

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        // Shape redCircle = new RedShapeDecorator(new Circle());
        // Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("带正常边界的圆");
        circle.draw();

        System.out.println("\n红色边框的圆");
        redCircle.draw();

        System.out.println("\n红色边框的长方形");
        redRectangle.draw();
    }
}