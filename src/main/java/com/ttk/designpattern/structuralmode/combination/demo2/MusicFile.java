package com.ttk.designpattern.structuralmode.combination.demo2;

/**
 * 叶子构件
 * 音乐
 */
public class MusicFile extends AbstractFile {

    private String name;

    public MusicFile(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }
}