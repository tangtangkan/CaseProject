package com.ttk.designpattern.behaviorpattern.strategies;

/**
 * 加法
 */
public class OperationAdd implements AlgorithmStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public AlgorithmEnum getType() {
        return AlgorithmEnum.ADD;
    }
}