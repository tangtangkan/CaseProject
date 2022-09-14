package com.ttk.designpattern.creationmode.singleton.sluggard;

/**
 * 懒汉（双重检验，线程安全）
 */
public class SingletonSaFeTwo {

    private static volatile SingletonSaFeTwo instance;

    private String value;

    private SingletonSaFeTwo(String value) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonSaFeTwo getInstance(String value) {
        if (instance == null) {
            synchronized (SingletonSaFeTwo.class) {
                if (instance == null) {
                    instance = new SingletonSaFeTwo(value);
                }
            }
        }
        return instance;
    }

    /**
     * 客户端代码
     */
    static class ThreadXu implements Runnable {

        @Override
        public void run() {
            SingletonSaFeTwo singleton = SingletonSaFeTwo.getInstance("xu");
            System.out.println(singleton.value);
        }
    }

    static class ThreadChuang implements Runnable {

        @Override
        public void run() {
            SingletonSaFeTwo singleton = SingletonSaFeTwo.getInstance("chaung");
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
