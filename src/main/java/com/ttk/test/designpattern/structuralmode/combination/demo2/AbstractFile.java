package com.ttk.test.designpattern.structuralmode.combination.demo2;

/**
 * 抽象构件
 * 文件
 */
public abstract class AbstractFile {

    public void add(AbstractFile file) {
        throw new UnsupportedOperationException();
    }

    public void remove(AbstractFile file) {
        throw new UnsupportedOperationException();
    }

    public AbstractFile getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}