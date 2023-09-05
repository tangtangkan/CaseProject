package com.ttk.examplecase.designpattern.behaviorpattern.strategies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 算法上下文
 */
public class AlgorithmContext {

    private Map<AlgorithmEnum, AlgorithmStrategy> algorithmStrategy = new HashMap<>();

    public AlgorithmContext(List<AlgorithmStrategy> strategyList) {
        for (AlgorithmStrategy strategy : strategyList) {
            algorithmStrategy.put(strategy.getType(), strategy);
        }
    }

    public int jisuan(int a, int b, AlgorithmEnum algorithmEnum) {
        return algorithmStrategy.get(algorithmEnum).doOperation(a, b);
    }

}
