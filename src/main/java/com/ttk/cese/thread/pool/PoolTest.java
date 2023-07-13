package com.ttk.cese.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolTest {
    public static void main(String[] args) {
        /**
         * 1. 核心线程数
         * 2. 最大线程数
         * 3. 空闲线程等待工作的超时时间
         * 4. 空闲线程等待工作的超时时间单位
         * 5. 线程等待队列数
         * 6. 线程工厂
         * 7. 线程拒绝策略
         */
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 8; i++) {
            executorService.execute(() ->{
                System.out.println(Thread.currentThread().getName() + "执行");
            });
        }

        executorService.shutdown();

    }
}
