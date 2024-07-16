package com.ttk.examplecase.shangguigu;

import java.util.ArrayList;
import java.util.List;

public class ListDistinctDemo {

    public static void main(String[] args) {
        /**
         * list去重
         */
        List<Integer> initList = getIntegers();
        // m1(initList);
        m2(initList);
    }

    private static void m1(List<Integer> initList) {
        List<Integer> newList = new ArrayList<>(initList);

        // 循环的是initList
        for (Integer i : initList) {

            // 获取下标的是newList
            int indexOf = newList.indexOf(i);
            int lastIndexOf = newList.lastIndexOf(i);

            // 删除的是newList
            if (indexOf != lastIndexOf) {
                newList.remove(i);
            }
        }
        newList.forEach(System.out::println);
    }

    private static void m2(List<Integer> initList) {
        List<Integer> newList = new ArrayList<>(initList);

        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = newList.size() - 1 ; j > i; j--) {
                if (newList.get(j).equals(newList.get(i))) {
                    newList.remove(j);
                }
            }
        }
        newList.forEach(System.out::println);
    }

    private static List<Integer> getIntegers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(300);
        numbers.add(500);
        numbers.add(100);
        return numbers;
    }

}
