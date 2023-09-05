package com.ttk.examplecase.thread;

public class ThreadTest {
    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable, "刘备");
        Thread thread2 = new Thread(myRunnable, "关羽");
        // Thread thread3 = new Thread(myRunnable, "张飞");

        // thread1.start();
        // try {
        //     thread1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // thread2.start();
        // thread3.start();


        thread1.start();
        try {
            thread1.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();

        System.out.println(thread1.getName() + ":" + thread1.getState());
        System.out.println(thread2.getName() + ":" + thread2.getState());

    }
}
