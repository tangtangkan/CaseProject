package com.ttk.test;

import com.google.common.collect.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
        // System.out.println(l);

        // String aa = "1970-01-01 23:00";
        //
        // String bb = "yyyy-MM-dd HH:mm";
        //
        // try {
        //     Date date = new SimpleDateFormat(bb).parse(aa);
        //     Instant instant = date.toInstant();
        //     ZoneId zoneId = ZoneId.systemDefault();
        //     LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        //     long l = localDateTime.toEpochSecond(ZoneOffset.UTC);
        //     System.out.println(l);
        //
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }

        // List<Middleware> list = Lists.newArrayList();

        // Middleware middleware1 = new Middleware();
        // middleware1.setA(1);
        //
        // Middleware middleware2 = new Middleware();
        // middleware2.setA(2);
        //
        // Middleware middleware3 = new Middleware();
        // middleware3.setA(3);
        //
        // Middleware middleware4 = new Middleware();
        // middleware4.setA(4);
        //
        // Middleware[] middlewares = new Middleware[3];
        // middlewares[0] = middleware2;
        // middlewares[1] = middleware3;
        // middlewares[2] = middleware4;
        //
        // Middleware link = Middleware.link(middleware1, middlewares);
        // System.out.println(link.getA());
        // System.out.println(link.getNext().getA());
        // System.out.println(link.getNext().getNext().getA());
        // System.out.println(link.getNext().getNext().getNext().getA());

        int a = 1;
        for (int i = 0; i < 10; i++) {
            // a++;
            // System.out.println(a);
            System.out.println(a++);
            System.out.println(a);
            if (a > 5) {
                Thread.currentThread().stop();
            }
        }

    }
}
