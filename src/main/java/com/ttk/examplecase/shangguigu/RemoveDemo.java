package com.ttk.examplecase.shangguigu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == 12) {
                /**
                 * 错误删除元素，在迭代器next的时候，会有一个初始数量和实际数量的校验，如果不一致就会报错
                 */
                // list.remove(value);

                // 正确删除元素
                iterator.remove();
            }
        }

        list.forEach(System.out::println);
    }

}
