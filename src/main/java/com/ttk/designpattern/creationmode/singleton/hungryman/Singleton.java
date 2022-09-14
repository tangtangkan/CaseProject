package com.ttk.designpattern.creationmode.singleton.hungryman;

/**
 * 饿汉
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getSingleton() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getSingleton();
    }

}
