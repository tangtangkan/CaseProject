package com.ttk.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
        // System.out.println(l);

        String aa = "1970-01-01 23:00";

        String bb = "yyyy-MM-dd HH:mm";

        try {
            Date date = new SimpleDateFormat(bb).parse(aa);
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
            long l = localDateTime.toEpochSecond(ZoneOffset.UTC);
            System.out.println(l);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
