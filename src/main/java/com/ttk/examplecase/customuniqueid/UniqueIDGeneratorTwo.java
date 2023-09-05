package com.ttk.examplecase.customuniqueid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这段代码使用了AtomicInteger类来保证计数器线程安全
 * 并使用ThreadLocal类来保证SimpleDateFormat实例线程安全
 * 在每次调用generateID()方法时，它会返回一个唯一的ID
 * 以"GG"为前缀，后跟当前日期和一个递增的三位数字（从001开始）。
 * 递增的数字每天都会从1开始，因为计数器是线程安全的，所以在多线程环境下也能正常工作。
 */
public class UniqueIDGeneratorTwo {

    private static final String PREFIX = "GG";
    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final int PADDING_LENGTH = 3;
    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat(DATE_FORMAT));

    public static String generateID() {
        StringBuilder builder = new StringBuilder();
        builder.append(PREFIX);
        builder.append(dateFormat.get().format(new Date()));
        builder.append(String.format("%0" + PADDING_LENGTH + "d", counter.getAndIncrement()));
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateID());
        System.out.println(generateID());
        System.out.println(generateID());
    }
}
