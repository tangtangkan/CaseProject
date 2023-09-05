package com.ttk.examplecase.thread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatch downLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> {
            System.out.println("玩家1开始准备");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downLatch.countDown();
            System.out.println("玩家1准备结束, 等待其余玩家数量：" + downLatch.getCount());
        });

        executorService.submit(() -> {
            System.out.println("玩家2开始准备");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downLatch.countDown();
            System.out.println("玩家2准备结束, 等待其余玩家数量：" + downLatch.getCount());
        });

        executorService.submit(() -> {
            System.out.println("玩家3开始准备");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downLatch.countDown();
            System.out.println("玩家3准备结束, 等待其余玩家数量：" + downLatch.getCount());
        });

        executorService.submit(() -> {
            try {
                System.out.println();
                downLatch.await();
                System.out.println("全部玩家准备结束, 开始游戏");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

    }
}

