package com.ttk.examplecase.thread;

public class WaitDemo implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        WaitDemo w = new WaitDemo();
        Thread one = new Thread(w);

        // 给WaitDemo加锁
        synchronized (WaitDemo.class) {
            // 开始启动子线程
            System.out.println("开始启动子线程:" + Thread.currentThread().getName());

            // 因为当前锁被主线程占有，所以不会执行子线程的run方法
            one.start();

            // 主线程开始调用wait()方法
            System.out.println("开始调用 wait 方法");
            WaitDemo.class.wait();
            System.out.println("主线程中调用wait方法之后的代码");
        }
    }

    @Override
    public void run() {
        System.out.println("进入子线程run方法:" + Thread.currentThread().getName());

        // 给WaitDemo加锁
        synchronized (WaitDemo.class) {
            try {
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始调用子线程notify方法");
            WaitDemo.class.notify();
        }
    }
}
