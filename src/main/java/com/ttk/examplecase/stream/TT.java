package com.ttk.examplecase.stream;

public class TT {

    public static void main(String[] args) {

        int a = 10;
        int b = 4;

        // a = a + b;
        // b = a - b;
        // a = a - b;

        a = a + b - (b = a);
        // a = 14 - 10, b = 10
        // a = 4, b = 10

        System.out.println(a);
        System.out.println(b);

    }

}
