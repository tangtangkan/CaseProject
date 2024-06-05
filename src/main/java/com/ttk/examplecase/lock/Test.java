package com.ttk.examplecase.lock;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ttl测试
 *
 * @author zhangyunhe
 * @date 2020-04-23 12:47
 */
public class Test {

    // 1. 初始化一个TransmittableThreadLocal，这个是继承了InheritableThreadLocal的
    static TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();

    // 初始化一个长度为1的线程池
    static ExecutorService poolExecutor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Test test = new Test();
        test.test();
    }
    private void test() throws InterruptedException, ExecutionException {

        // 设置初始值
        local.set("天王老子");
        //！！！！ 注意：这个地方的Task是使用了TtlRunnable包装的
        Future future = poolExecutor.submit(TtlRunnable.get(new Task("任务1")));
        // Future future = poolExecutor.submit(new Task("任务1"));
        future.get();

        Future future2 = poolExecutor.submit(TtlRunnable.get(new Task("任务2")));
        // Future future2 = poolExecutor.submit(new Task("任务2"));
        future2.get();
      
        System.out.println("父线程的值："+local.get());
        poolExecutor.shutdown();
    }

    class Task implements Runnable{

        String str;
        Task(String str){
            this.str = str;
        }
        @Override
        public void run() {
            // 获取值
            System.out.println(Thread.currentThread().getName()+":"+local.get());
            // 重新设置一波
            local.set(str);
        }
    }
}
