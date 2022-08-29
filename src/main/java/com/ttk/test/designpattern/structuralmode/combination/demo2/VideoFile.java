package com.ttk.test.designpattern.structuralmode.combination.demo2;

/**
 * 叶子构件
 * 视频
 */
public class VideoFile extends AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}