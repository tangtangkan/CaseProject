package com.ttk.examplecase.shangguigu;

public class IntegerDemo {

    public static void main(String[] args) {

        // java8的写法
        Integer i1 = new Integer(1);

        // java17的写法，上面的写法会报错
        Integer i2 = Integer.valueOf(1);

        /**
         * 所有整型包装类的比较，都使用equals方法
         *
         * 对于Integer在-128到127之间，获取的是缓存常量池中的数据，可以使用==比较，不在这个范围中时，都会在堆中产生，需要使用quals比较
         */

        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        Integer c = 127;

        Integer a1 = Integer.valueOf(128);
        Integer b1 = Integer.valueOf(128);
        Integer c1 = 128;

        // -128到127之间
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        // -128到127之外
        System.out.println(a1 == b1);
        System.out.println(a1 == c1);
        System.out.println(a1.equals(b1));
        System.out.println(a1.equals(c1));
    }

}
