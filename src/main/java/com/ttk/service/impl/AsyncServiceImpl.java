package com.ttk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttk.examplecase.thread.async.AsyncTestService;
import com.ttk.dao.MessageRecordMapper;
import com.ttk.entity.MessageRecord;
import com.ttk.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl extends ServiceImpl<MessageRecordMapper, MessageRecord> implements AsyncService {

    private final AsyncTestService asyncTestService;

    @Autowired
    public AsyncServiceImpl(AsyncTestService asyncTestService) {
        this.asyncTestService = asyncTestService;
    }

    @Override
    public void test() {

        try {
            System.out.println("主线程开始");

            asyncTestService.asyncThread();
            // asyncThread();

            Thread.sleep(2000);

            System.out.println("主线程结束");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 1. Spring在扫描bean的时候会扫描方法上是否包含@Async注解，动态地生成一个子类（即proxy代理类），当这个有注解的方法被调用的时候，实际上是由代理类来调用的，代理类在调用时增加异步作用。
     * 2. 如果这个有注解的方法是被同一个类中的其他方法调用的，那么该方法的调用并没有通过代理类，而是直接通过原来的那个 bean，所以就失效了。
     * 3. 所以调用方与被调方不能在同一个类，主要是使用了动态代理，同一个类的时候直接调用，不是通过生成的动态代理类调用。
     * 4. 一般将要异步执行的方法单独抽取成一个类。
     *
     * 5. 调用方和被调用方如果在一个类中生效, 那么需要在类上加上@Async注解
     */
    @Async
    public void asyncThread() throws InterruptedException {

        System.out.println("异步线程开始");

        Thread.sleep(5000);

        System.out.println("异步线程结束");
    }
}
