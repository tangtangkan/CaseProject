package com.ttk.examplecase.shangguigu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {

        // // Arrays只是一个工具类，Arrays.asList继承自AbstractList，重写了add()、remove()等修改List结构的方法，并将它们抛出异常，禁止对List结构的修改
        // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //
        // list.add(6);
        //
        // list.forEach(System.out::println);

        // 非要用
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.add(6);

        list.forEach(System.out::println);

    }

}
