package com.ttk.examplecase.thread;

public class WaitDemo1 {

    public static void main(String[] args) throws InterruptedException {

        WaitDemo2 w = new WaitDemo2();
        Thread one = new Thread(w);

        // 给WaitDemo加锁
        synchronized (WaitDemo1.class) {
            // 开始启动子线程
            System.out.println("开始启动子线程:" + Thread.currentThread().getName());

            // 因为当前锁被主线程占有，所以不会执行子线程的run方法
            one.start();

            // 主线程开始调用wait()方法
            System.out.println("开始调用 wait 方法");
            WaitDemo1.class.wait();
            System.out.println("主线程中调用wait方法之后的代码");
        }
    }
}
