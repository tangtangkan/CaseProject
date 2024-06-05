package com.ttk.examplecase.ms.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TtlTest1 {

    /**
     * 背景：
     * 电商平台的订单处理系统
     * 每个用户请求需要记录用户信息
     * 在异步任务中使用这些信息进行订单处理和日志记录
     * <p>
     * 1. 用户提交订单
     * 2. 在父线程中获取用户信息
     * 3. 在异步线程中
     *    3.1 生成订单，需包含用户信息
     *    3.2 记录日志，需包含用户信息
     */

    // 定义一个TransmittableThreadLocal，用来向异步线程传递用户信息
    private static final TransmittableThreadLocal<String> userContext = new TransmittableThreadLocal<>();

    // 创建一个固定大小的线程池
    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);

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
        for (int i = 1; i <= 2; i++) {
            processOrder("order" + i);

            // 在父线程中修改userContext的值
            userContext.set(""+i);
        }

        // 关闭线程池并等待任务完成
        executorService.shutdown();
    }

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
                Thread.sleep(1000);
                System.out.println("orderTask====线程ID：" + Thread.currentThread().getId() + "，处理订单，订单ID：" + orderId + "，用户ID：" + userContext.get());
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        // 创建异步线程记录日志
        Runnable logTask = () -> {
            // 模拟记录日志时长
            try {
                Thread.sleep(1000);
                System.out.println("logTask====线程ID：" + Thread.currentThread().getId() + "，记录日志，订单ID：" + orderId + "，用户ID：" + userContext.get());
                System.out.println();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        // 提交任务到线程池，使用TtlRunnable包装以传递上下文
        // executorService.execute(TtlRunnable.get(orderTask));
        executorService.execute(TtlRunnable.get(logTask));
        // executorService.execute(orderTask);
        // executorService.execute(logTask);

        // 清理父线程的TransmittableThreadLocal
        userContext.remove();
    }

}
