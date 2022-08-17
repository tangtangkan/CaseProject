package com.ttk.test.designpattern.behaviorpattern.duty.demo2;

/**
 * Debug日志
 */
public class DebugLogger extends AbstractLogger {
 
   public DebugLogger(int level){
      this.level = level;
   }
 
   @Override
   protected void write(String message) {    
      System.out.println("Debug: " + message);
   }
}