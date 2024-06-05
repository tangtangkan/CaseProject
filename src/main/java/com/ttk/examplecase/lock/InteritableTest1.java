package com.ttk.examplecase.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 父子线程如何共享数据
 *
 * 方案一： 使用InheritableThreadLocal
 *    问题：循环三次，每次打印local的值是相同的
 *    原因：InheritableThreadLocal 工作原理：当一个新线程被创建时，它会从父线程继承InheritableThreadLocal的值，通过线程初始化时的一个副本来实现的
 *         线程池中的线程是复用的，所以一个线程在完成任务后，不会马上销毁，而是继续执行新的任务，所以不会重新继承父线程中的值
 *         代码执行过程：首先main主线程设置InheritableThreadLocal的初始值，然后提交任务到子线程，然后主线程修改local的值，在子线程中打印的还是初始值
 *    注：当线程池大小为1，循环3次，每次是使用相同的线程执行，才会使打印的值相同
 *        如果程池大小大于循环次数，那么每次使用的是新的线程，就不会有这个问题
 */
public class InteritableTest1 {

    static ThreadLocal<String> local = new InheritableThreadLocal<>();

    // 初始化一个长度为1 的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InteritableTest1 test = new InteritableTest1();
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
