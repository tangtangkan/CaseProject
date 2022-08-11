package com.ttk.test.designpattern.creationmode.singleton.hungryman;

/**
 * 基础单例（单线程）
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public static void main(String[] args) {

        // Singleton singleton1 = Singleton.getInstance("徐");
        // Singleton singleton2 = Singleton.getInstance("闯");
        // System.out.println(singleton1.value);
        // System.out.println(singleton2.value);

        Thread threadX = new Thread(new ThreadXu());
        Thread threadC = new Thread(new ThreadChuang());
        threadX.start();
        threadC.start();

    }

    static class ThreadXu implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance();
            System.out.println();
        }
    }

    static class ThreadChuang implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance();
        }
    }

}
