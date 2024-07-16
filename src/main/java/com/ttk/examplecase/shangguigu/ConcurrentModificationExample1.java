package com.ttk.examplecase.shangguigu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample1 {

    public static void main(String[] args) {
        List<Integer> numbers = getIntegers();
        /**
         * 测试下来，只有m4会报ConcurrentModificationException异常，但不能以此为准，应该使用m5这种正确的写法
         */
        m5(numbers);
    }

    private static List<Integer> getIntegers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        return numbers;
    }

    private static void m1(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number == 2) {
                // 下面这行代码会导致 ConcurrentModificationException 异常
                numbers.remove(number);
            }
        }
    }

    private static void m2(List<Integer> numbers) {
        for (int i = 0; i <numbers.size(); i++) {
            if (numbers.get(i) == 2) {
                // 下面这行代码会导致 ConcurrentModificationException 异常
                numbers.remove(numbers.get(i));
            }
        }
    }

    private static void m3(List<Integer> numbers) {

        for (Integer number : numbers) {
            if (number == 2) {
                // 下面这行代码会导致 ConcurrentModificationException 异常
                numbers.remove(number);
            }
        }
    }

    private static void m4(List<Integer> numbers) {

        numbers.forEach(number -> {
            if (number == 2) {
                // 下面这行代码会导致 ConcurrentModificationException 异常
                numbers.remove(number);
            }
        });
    }

    private static void m5(List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number == 2) {
                iterator.remove();
            }
        }
    }
}
