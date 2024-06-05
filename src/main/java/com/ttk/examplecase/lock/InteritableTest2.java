package com.ttk.examplecase.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 父子线程如何共享数据
 *
 * InteritableTest1问题解决方案一：在每次提交线程时，重新设置local的值
 */
public class InteritableTest2 {

    static ThreadLocal<String> local = new InheritableThreadLocal<>();

    // 初始化一个长度为1 的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InteritableTest2 test = new InteritableTest2();
        test.test();
    }

    private void test() {
        // 父线程设置一个初始值
        local.set("天王老子");

        for (int i = 1; i <= 3; i++) {

            // 子线程继承父线程local的值
            poolExecutor.submit(new Task(local.get()));

            // 父线程修改local的值
            local.set("天王老子" + i);
        }

        // 关闭线程池并等待任务完成
        poolExecutor.shutdown();
    }

    class Task implements Runnable {

        private String value;

        public void setValue(String value) {
            this.value = value;
        }

        public Task(String value) {
            this.value = value;
        }

        @Override
        public void run() {
            // 重新设置local的值
            local.set(value);

            // 子线程里面打印获取到的值
            System.out.println(Thread.currentThread().getName() + ":" + local.get());
        }
    }
}
