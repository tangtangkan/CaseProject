package com.ttk.cese.customuniqueid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在这个实现中，我们使用了Java的LocalDate类来获取当前日期，使用DateTimeFormatter来格式化日期字符串。
 * 我们还使用了AtomicInteger类来保证递增数字的线程安全性，
 * 从001开始每天递增，如果递增到了999则从1重新开始。最后，我们使用String.format方法来格式化递增数字，以确保它们总是三位数。
 * 最终返回的字符串为"GG20230321001"这样的格式。
 */
public class UniqueIdGeneratorThree {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    public static synchronized String generateId() {
        LocalDate today = LocalDate.now();
        int counter = COUNTER.getAndIncrement();
        if (counter > 999) {
            COUNTER.set(1);
            counter = 1;
        }
        return "GG" + today.format(DATE_FORMAT) + String.format("%03d", counter);
    }
}
