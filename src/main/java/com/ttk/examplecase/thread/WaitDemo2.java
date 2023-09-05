package com.ttk.examplecase.thread;

public class WaitDemo2 implements Runnable {
    @Override
    public void run() {
        System.out.println("进入子线程run方法:" + Thread.currentThread().getName());

        // 给WaitDemo加锁
        synchronized (WaitDemo1.class) {
            try {
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WaitDemo1.class.notify();
        }
    }
}
