package com.ttk.test.designpattern.behaviorpattern.strategies;

import com.google.common.collect.Lists;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<AlgorithmStrategy> list = Lists.newArrayList();
        list.add(new OperationAdd());
        list.add(new OperationMultiply());
        list.add(new OperationSubtract());

        AlgorithmContext algorithmContext = new AlgorithmContext(list);
        // AlgorithmContext algorithmContext = new AlgorithmContext();

        int result1 = algorithmContext.jisuan(20, 10, AlgorithmEnum.ADD);
        int result2 = algorithmContext.jisuan(20, 10, AlgorithmEnum.SUBTRACT);
        int result3 = algorithmContext.jisuan(20, 10, AlgorithmEnum.MULTIPLY);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }
}
