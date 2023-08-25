package com.ttk.cese.thread;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行");

        // 创建一个子线程
        Thread childThread = new Thread(() -> {
            System.out.println("子线程开始执行");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程执行完成");
        });

        // 启动子线程
        childThread.start();

        // 使用join()方法等待子线程执行完成
        childThread.join();

        System.out.println("主线程继续执行");
    }
}
