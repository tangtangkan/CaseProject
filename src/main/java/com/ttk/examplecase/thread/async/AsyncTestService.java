package com.ttk.examplecase.thread.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTestService {

    @Async
    public void asyncThread() throws InterruptedException {

        System.out.println("异步线程开始");

        Thread.sleep(5000);

        System.out.println("异步线程结束");
    }

}
