package com.ttk.test.designpattern.structuralmode.combination.demo2;


import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件
 */
public class Folder extends AbstractFile {

    private String name;

    private List<AbstractFile> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        files.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        files.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return files.get(i);
    }

    @Override
    public void print() {
        for (AbstractFile file : files) {
            file.print();
        }
    }
}