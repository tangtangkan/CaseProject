package com.ttk.examplecase.ms.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.*;

public class OrderProcessingService {

    // 定义一个TransmittableThreadLocal，用于传递用户信息
    private static final TransmittableThreadLocal<String> userContext = new TransmittableThreadLocal<>();

    // 创建一个固定大小的线程池
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    // 使用阻塞队列在任务之间传递数据
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        // 模拟用户提交订单
        processOrder("user123", "order456");
    }

    public static void processOrder(String userId, String orderId) {
        // 在父线程中设置用户信息
        userContext.set(userId);

        // 创建异步任务
        Runnable orderTask = () -> {
            try {
                // 模拟订单处理
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println("orderTask====线程ID：" + Thread.currentThread().getId() + "====");
                // System.out.println("orderTask====处理订单：" + orderId);
                System.out.println("orderTask====用户ID：" + userContext.get());
                System.out.println();
                
                // 处理完成后，将订单ID放入队列
                queue.put(orderId);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable logTask = () -> {
            try {
                // 从队列中获取订单ID
                // String processedOrderId = queue.take();
                
                // 模拟日志记录
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("logTask====线程ID：" + Thread.currentThread().getId() + "====");
                // System.out.println("logTask====处理订单：" + processedOrderId);
                System.out.println("logTask====用户ID：" + userContext.get());
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
}
