package com.ttk.test.designpattern.creationmode.singleton.multithreading;

public class Singleton {

    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }

        synchronized (Singleton.class) {
            if (instance == null) {
                return new Singleton(value);
            }
            return instance;
        }
    }

}
