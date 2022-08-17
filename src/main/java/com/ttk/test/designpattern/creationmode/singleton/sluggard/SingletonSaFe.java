package com.ttk.test.designpattern.creationmode.singleton.sluggard;

/**
 * 懒汉（同步锁，线程安全）
 * 锁的粒度太大，效率低
 */
public class SingletonSaFe {

    private static SingletonSaFe instance;

    private String value;

    private SingletonSaFe(String value) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static synchronized SingletonSaFe getInstance(String value) {
        if (instance == null) {
            instance = new SingletonSaFe(value);
        }
        return instance;
    }

    /**
     * 客户端代码
     */
    static class ThreadXu implements Runnable {

        @Override
        public void run() {
            SingletonSaFe singleton = SingletonSaFe.getInstance("xu");
            System.out.println(singleton.value);
        }
    }

    static class ThreadChuang implements Runnable {

        @Override
        public void run() {
            SingletonSaFe singleton = SingletonSaFe.getInstance("chaung");
            System.out.println(singleton.value);
        }
    }

    public static void main(String[] args) {

        Thread threadX = new Thread(new ThreadXu());
        Thread threadC = new Thread(new ThreadChuang());
        threadX.start();
        threadC.start();

    }

}
