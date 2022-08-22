package com.ttk.test.designpattern.structuralmode.proxy.demo1;

/**
 * 代理图片类
 */
public class ProxyImage implements Image {

    private Image image;

    private String fileName;

    public ProxyImage(String fileName, Image image) {
        this.fileName = fileName;
        this.image = image;
    }

    @Override
    public void display() {
        image.display();
    }
}