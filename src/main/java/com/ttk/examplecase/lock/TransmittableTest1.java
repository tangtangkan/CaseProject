package com.ttk.examplecase.lock;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 父子线程如何共享数据
 *
 * 方案二： 使用TransmittableThreadLocal配合TtlRunnable.get()
 *
 *    TransmittableThreadLocal是在任务提交时，去拷贝父线程的值
 *
 *    TtlRunnable是一个包装器，在任务提交时，捕获父线程TransmittableThreadLocal的上下文
 */
public class TransmittableTest1 {

    static TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();

    // 初始化一个长度为1 的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TransmittableTest1 test = new TransmittableTest1();
        test.test();
    }

    private void test() {
        // 设置一个初始值
        local.set("天王老子");

        for (int i = 1; i <= 3; i++) {
            local.set("天王老子" + i);
            poolExecutor.submit(TtlRunnable.get(new Task()));
        }

        poolExecutor.shutdown();
    }

    class Task implements Runnable {
        @Override
        public void run() {
            // 子线程里面打印获取到的值
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
        }
    }
}
