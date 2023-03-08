package com.ttk.cese.javaBasics;

/**
 * 变量交换
 */
public class VariableExchange {

    public static void main(String[] args) {

        int a = 10;
        int b = 4;

        // 方法一
        // a = a + b;
        // b = a - b;
        // a = a - b;

        // 方法二
        a = a + b - (b = a);

        System.out.println(a);
        System.out.println(b);

    }

}
