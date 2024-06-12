package com.ttk.examplecase.thread.pool;

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
         *
         * 银行总柜台5个（最大线程数）
         * 周末上班柜台3个（核心线程数）
         * 不上班柜台2个（空闲线程数）
         * 银行等待座位3个（等待队列数）
         *
         * 当1来办理业务，去柜台1
         * 当2来办理业务，去柜台2
         * 当3来办理业务，去柜台3
         * 当4来办理业务，上班柜台满了，去座位1
         * 当5来办理业务，去座位2
         * 当6来办理业务，去座位3
         * 当7来办理业务，座位也满了，叫柜台4和柜台5来加班，4去柜台4，5去柜台5，6去座位1，7去座位2
         * 当8来办理业务，去座位3
         * 当9来办理业务，所有柜台和座位都满了，不能办理（拒绝策略）
         * 当其他人都办理完走了，只剩下123在柜台123时，柜台4和柜台5为空闲状态，等待一定时间后，没有新的人来办理业务时，柜台4和柜台5下班（空闲线程等待时间、单位）
         */
        ExecutorService executorService = new ThreadPoolExecutor(
                3,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 9; i++) {
            executorService.execute(() ->{
                System.out.println(Thread.currentThread().getName() + "执行");
            });
        }

        executorService.shutdown();

    }
}
