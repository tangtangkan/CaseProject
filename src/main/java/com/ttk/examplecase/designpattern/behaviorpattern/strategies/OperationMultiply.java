package com.ttk.examplecase.designpattern.behaviorpattern.strategies;

/**
 * 乘法
 */
public class OperationMultiply implements AlgorithmStrategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public AlgorithmEnum getType() {
        return AlgorithmEnum.MULTIPLY;
    }

}