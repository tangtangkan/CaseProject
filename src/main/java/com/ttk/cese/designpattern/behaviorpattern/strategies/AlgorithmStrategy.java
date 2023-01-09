package com.ttk.cese.designpattern.behaviorpattern.strategies;

/**
 * 算法策略
 */
public interface AlgorithmStrategy {

    int doOperation(int num1, int num2);

    AlgorithmEnum getType();

}