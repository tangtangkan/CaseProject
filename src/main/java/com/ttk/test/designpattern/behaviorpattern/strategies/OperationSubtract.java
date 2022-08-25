package com.ttk.test.designpattern.behaviorpattern.strategies;

/**
 * 减法
 */
public class OperationSubtract implements AlgorithmStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public AlgorithmEnum getType() {
        return AlgorithmEnum.SUBTRACT;
    }
}