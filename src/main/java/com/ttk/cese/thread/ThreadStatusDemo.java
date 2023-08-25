package com.ttk.cese.thread;

public class ThreadStatusDemo {

    public static void main(String[] args) throws InterruptedException {

        // 创建一个新的线程thread
        Thread thread = new Thread(() -> {
            try {
                // 让线程阻塞1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        // 输出线程thread状态为 New（新建）
        System.out.println("线程状态：" + thread.getState());

        // 线程thread开始执行
        thread.start();

        // 输出线程thread状态为 Runnable（运行）
        System.out.println("线程状态：" + thread.getState());

        // 主线程等待200毫秒，确保线程thread有足够时间进入阻塞状态
        Thread.sleep(200);

        // 输出线程thread状态为 Blocked（阻塞）
        System.out.println("线程状态：" + thread.getState());

        // 等待1秒，确保线程thread执行完毕
        Thread.sleep(1000);

        // 输出线程状态为 Terminated（终止）
        System.out.println("线程状态：" + thread.getState());
    }

}
