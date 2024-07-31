package com.ttk.examplecase.thread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    /**
     * CountDownLatch内部维护了一个计数器，在声明CountDownLatch时，构造函数中传入count数量，每次调用countDown()方法，让计数器-1，当计数器为0的时候，所有调用await()方法等待、阻塞的线程，都会被唤醒
     *
     * 使用三个线程代表三个玩家
     * 每个线程让线程休眠，设置不同休眠时长
     * 每个线程在休眠后，调用CountDownLatch.countDown()方法，让计数器-1
     * 在main主线程中，调用CountDownLatch.await()方法，等待CountDownLatch的计数器为0，此时main主线程等待、阻塞，等待CountDownLatch为0后，继续执行main主线程
     */
    public static void main(String[] args) {

        // 声明一个数量为3的计数器
        CountDownLatch downLatch = new CountDownLatch(3);
        // 声明一个固定数量为4的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> {
            System.out.println("玩家1开始准备");
            try {
                // 休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 计数器减1
            downLatch.countDown();
            System.out.println("玩家1准备结束, 等待其余玩家数量：" + downLatch.getCount());
            System.out.println();
        });

        executorService.submit(() -> {
            System.out.println("玩家2开始准备");
            try {
                // 休眠5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 计数器减1
            downLatch.countDown();
            System.out.println("玩家2准备结束, 等待其余玩家数量：" + downLatch.getCount());
            System.out.println();
        });

        executorService.submit(() -> {
            System.out.println("玩家3开始准备");
            try {
                // 休眠10秒
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 计数器减1
            downLatch.countDown();
            System.out.println("玩家3准备结束, 等待其余玩家数量：" + downLatch.getCount());
            System.out.println();
        });

        executorService.submit(() -> {
            try {
                System.out.println();
                // 等待计数器为0
                downLatch.await();

                System.out.println();
                System.out.println("全部玩家准备结束, 开始游戏");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

    }
}

