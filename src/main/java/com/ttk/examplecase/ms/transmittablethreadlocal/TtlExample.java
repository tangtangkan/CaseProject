package com.ttk.examplecase.ms.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 父子线程如何共享数据
 *
 * 使用TransmittableThreadLocal + TtlRunnable配合使用
 *
 * 在线程池中只有一个线程时，
 */
public class TtlExample {

    public static void main(String[] args) {

        // 创建一个TransmittableThreadLocal实例
        final TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
        transmittableThreadLocal.set("Initial Value");

        // 创建一个Runnable任务
        Runnable runnable = () -> {
            try {
                // 模拟任务执行时间
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("====Runnable线程ID：" + Thread.currentThread().getId() + "====");
            // 打印当前线程的TransmittableThreadLocal的值
            System.out.println("TransmittableThreadLocal值：" + transmittableThreadLocal.get());
            System.out.println();
        };

        // 创建一个固定大小为1的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 循环三次
        int i = 0;
        while (i < 3) {
            // 包装Runnable任务，保证线程池中的任务能够继承当前线程的TransmittableThreadLocal的值
            executorService.execute(TtlRunnable.get(runnable));
            // executorService.execute(runnable);

            // 主线程修改TransmittableThreadLocal的值
            transmittableThreadLocal.set(i + "AA");
            i++;
        }

        // 关闭线程池
        executorService.shutdown();
    }
}