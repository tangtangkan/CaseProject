package com.ttk.examplecase.thread;

public class BlockedTest {

    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "c");

        a.start();
        try {
        //     Thread.sleep(1000);
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
        System.out.println(c.getName() + ":" + c.getState());
    }

    // 同步方法争夺锁
    private synchronized static void testMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
