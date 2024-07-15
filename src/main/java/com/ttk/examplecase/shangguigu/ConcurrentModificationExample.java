package com.ttk.examplecase.shangguigu;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // 线程1：遍历并尝试删除元素
        Thread thread1 = new Thread(() -> {
            try {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer value = iterator.next();
                    System.out.println("Thread 1: " + value);
                    if (value == 5) {
                        // 错误地使用 list.remove 进行删除
                        list.remove(value);
                    }
                    // 模拟一些处理时间
                    Thread.sleep(10);
                }
            } catch (ConcurrentModificationException e) {
                System.err.println("Thread 1: Caught ConcurrentModificationException!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 线程2：修改列表
        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 10; i < 20; i++) {
                    list.add(i);
                    System.out.println("Thread 2: Added " + i);
                    // 模拟一些处理时间
                    Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final list: " + list);
    }
}
