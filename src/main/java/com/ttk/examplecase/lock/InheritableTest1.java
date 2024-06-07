package com.ttk.examplecase.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 父子线程如何共享数据
 *
 * 方案一： 使用InheritableThreadLocal
 *
 *    问题：循环三次，每次打印local的值是相同的
 *
 *    原因：InheritableThreadLocal的值是在子线程被创建时继承，代码中使用了固定大小为1的线程池，所以线程会被复用，子线程只会被创建一次，从而只会从父线程继承一次值，所以循环三次的打印结果都是一样的
 *
 *    代码执行过程：
 *      1. 父线程设置local的值为天王老子
 *      2. 父线程开启一个循环，循环3次
 *          第一次循环：
 *              子线程继承父线程的值天王老子，并打印local
 *              子线程修改local的值
 *          第二次循环：
 *              线程被复用，所以不会继承父线程的值
 *          第三次循环：
 *  *           线程被复用，所以不会继承父线程的值
 */
public class InheritableTest1 {

    // 初始化一个InheritableThreadLocal
    static ThreadLocal<String> local = new InheritableThreadLocal<>();

    // 初始化一个长度为1 的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InheritableTest1 test = new InheritableTest1();
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
