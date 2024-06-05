package com.ttk.examplecase.ms.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TtlTest2 {

    /**
     * 基于TtlTest1
     *
     * orderTask休眠500
     * logTask休眠1000
     * 在执行时，一定是orderTask先执行完毕，在orderTask中修改userContext为2，为什么在logTask中获取的userContext还是1
     * 原因：每个任务在被 TtlRunnable.get() 包装并提交到线程池时，TransmittableThreadLocal 的值已经被传递并固定下来了
     */

    // 定义一个TransmittableThreadLocal，用来向异步线程传递用户信息
    private static final TransmittableThreadLocal<String> userContext = new TransmittableThreadLocal<>();

    // 创建一个固定大小的线程池
    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    /**
     * 提交订单接口
     *
     * @param orderId
     */
    public static void processOrder(String orderId) {

        // 创建异步线程处理订单
        Runnable orderTask = () -> {
            // 模拟处理订单时长
            try {
                Thread.sleep(500);
                System.out.println("====线程ID：" + Thread.currentThread().getId() + "，处理订单，订单ID：" + orderId + "，用户ID：" + userContext.get());
                System.out.println();

                userContext.set("2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        // 创建异步线程记录日志
        Runnable logTask = () -> {
            // 模拟记录日志时长
            try {
                Thread.sleep(1000);
                System.out.println("====线程ID：" + Thread.currentThread().getId() + "，记录日志，订单ID：" + orderId + "，用户ID：" + userContext.get());
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        // 提交任务到线程池，使用TtlRunnable包装以传递上下文
        executorService.execute(TtlRunnable.get(orderTask));
        executorService.execute(TtlRunnable.get(logTask));

        // 清理父线程的TransmittableThreadLocal
        userContext.remove();
    }

    /**
     * 模拟用户提交订单
     *
     * TransmittableThreadLocal和TtlRunnable配合使用
     * 在main主线程设置用户ID为1，异步线程中获取用户ID
     */
    public static void main(String[] args) {

        // 在父线程中设置用户信息
        userContext.set("1");

        // 模拟用户提交订单
        for (int i = 1; i <= 1; i++) {
            processOrder("order" + i);
        }

        // 关闭线程池并等待任务完成
        executorService.shutdown();
    }

}
