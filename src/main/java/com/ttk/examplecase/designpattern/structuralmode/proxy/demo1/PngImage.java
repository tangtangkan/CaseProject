package com.ttk.examplecase.designpattern.structuralmode.proxy.demo1;

/**
 * 真实图片类
 */
public class PngImage implements Image {

    private String fileName;

    public PngImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("打开 " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("从磁盘加载PNG " + fileName);
    }
}