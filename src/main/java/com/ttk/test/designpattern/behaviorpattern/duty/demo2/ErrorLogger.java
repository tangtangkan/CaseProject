package com.ttk.test.designpattern.behaviorpattern.duty.demo2;

/**
 * Error日志
 */
public class ErrorLogger extends AbstractLogger {
 
   public ErrorLogger(int level){
      this.level = level;
   }
 
   @Override
   protected void write(String message) {    
      System.out.println("Error: " + message);
   }
}