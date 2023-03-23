package com.ttk.cese.customuniqueid;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueIDGenerator {
    private static int counter = 1;
    private static final String PREFIX = "GG";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static synchronized String generateUniqueID() {
        String uniqueID = PREFIX + dateFormat.format(new Date()) + String.format("%03d", counter++);
        return uniqueID;
    }

   public static void main(String[] args) {
      String s = UniqueIDGenerator.generateUniqueID();
      System.out.println(s);
   }
}