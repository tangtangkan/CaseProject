package com.ttk.cese.designpattern.structuralmode.combination.demo2;

/**
 * 叶子构件
 * 图片
 */
public class ImageFile extends AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}