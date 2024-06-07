package com.ttk.examplecase.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 父子线程如何共享数据
 *
 * 方案一： 使用InheritableThreadLocal
 *
 *    问题：对于InteritableTest1，现将线程池的大小改为3，每次都会打印出最新的值
 *
 *    代码执行过程：
 *          1. 父线程设置local的值为天王老子
 *          2. 父线程开启一个循环，循环3次
 *              第一次循环：
 *                  线程池中第一个线程继承父线程的local值天王老子
 *                  父线程修改local的值为天王老子1
 *              第二次循环：
 *                  线程池中第二个线程继承父线程的local值天王老子1
 *                  父线程修改local的值为天王老子2
 *              第二次循环：
 *                  线程池中第三个线程继承父线程的local值天王老子2
 *                  父线程修改local的值为天王老子3
 *
 */
public class InheritableTest2 {

    // 初始化一个InheritableThreadLocal
    static ThreadLocal<String> local = new InheritableThreadLocal<>();

    // 初始化一个长度为1 的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InheritableTest2 test = new InheritableTest2();
        test.test();
    }

    // 循环3次
    private void test() {

        // 父线程设置一个初始值
        local.set("天王老子");

        for (int i = 1; i <= 3; i++) {

            // 子线程继承父线程local的值
            poolExecutor.submit(new Task());

            // 父线程修改local的值
            local.set("天王老子" + i);
        }

        // 关闭线程池并等待任务完成
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
