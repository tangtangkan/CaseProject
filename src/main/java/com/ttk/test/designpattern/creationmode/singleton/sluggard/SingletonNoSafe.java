package com.ttk.test.designpattern.creationmode.singleton.sluggard;

/**
 * 懒汉（线程不安全）
 */
public class SingletonNoSafe {

    private static SingletonNoSafe instance;

    private String value;

    private SingletonNoSafe(String value) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonNoSafe getInstance(String value) {
        if (instance == null) {
            instance = new SingletonNoSafe(value);
        }
        return instance;
    }

    /**
     * 客户端代码
     * @param args
     */
    public static void main(String[] args) {

        Thread threadX = new Thread(new ThreadXu());
        Thread threadC = new Thread(new ThreadChuang());
        threadX.start();
        threadC.start();

    }

    static class ThreadXu implements Runnable {

        @Override
        public void run() {
            SingletonNoSafe singleton = SingletonNoSafe.getInstance("xu");
            System.out.println(singleton.value);
        }
    }

    static class ThreadChuang implements Runnable {

        @Override
        public void run() {
            SingletonNoSafe singleton = SingletonNoSafe.getInstance("chaung");
            System.out.println(singleton.value);
        }
    }

}
