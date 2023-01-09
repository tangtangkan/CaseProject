package com.ttk.cese.designpattern.structuralmode.proxy.demo1;

public class ProxyPatternDemo {

    public static void main(String[] args) {

        RealImage realImage = new RealImage("test_10mb.jpg");

        // 图像将从磁盘加载
        realImage.display();

        System.out.println();

        // 图像不需要从磁盘加载
        realImage.display();


        System.out.println();


        PngImage pngImage = new PngImage("test_10mb.png");

        // 图像将从磁盘加载
        pngImage.display();

        System.out.println();

        // 图像不需要从磁盘加载
        pngImage.display();
    }
}