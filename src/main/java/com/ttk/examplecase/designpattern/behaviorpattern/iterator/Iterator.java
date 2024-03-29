package com.ttk.examplecase.designpattern.behaviorpattern.iterator;

/**
 * 迭代器接口
 */
public interface Iterator {

    // 是否有下一个元素
    boolean hasNext();

    // 获取下一个元素
    Object next();

}