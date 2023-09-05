package com.ttk.examplecase.designpattern.behaviorpattern.duty.demo2;

public class ChainPatternDemo {

    public static void main(String[] args) {

        // 设置责任链
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "info message");
        System.out.println();

        loggerChain.logMessage(AbstractLogger.DEBUG,"debug message");
        System.out.println();

        loggerChain.logMessage(AbstractLogger.ERROR,"error message");
    }

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }
}