package com.ttk.designpattern.behaviorpattern.duty.demo2;

/**
 * Info日志
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info: " + message);
    }
}