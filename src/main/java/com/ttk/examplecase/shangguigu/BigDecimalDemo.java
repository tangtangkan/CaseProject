package com.ttk.examplecase.shangguigu;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {

    public static void main(String[] args) {

        // double精度丢失
        // doubleTest1();

        // double精度丢失
        // doubleTest2();

        // 使用String类型作为入参
        // doubleTest3();

        // 使用BigDecimal.valueOf
        // doubleTest4();

        // 等值比较
        // equalsTest5();

        // 除法精度范围
        // divideTest6();

        // 科学计数法
        test7();
    }

    /**
     * double精度丢失
     *
     * 值：0.009999999999999998
     */
    private static void doubleTest1() {
        double d1 = 0.03;
        double d2 = 0.02;
        System.out.println(d1 - d2);
    }

    /**
     * double精度丢失
     *
     * 0.0299999999999999988897769753748434595763683319091796875
     * 0.0200000000000000004163336342344337026588618755340576171875
     */
    private static void doubleTest2() {
        BigDecimal d1 = new BigDecimal(0.03);
        BigDecimal d2 = new BigDecimal(0.02);
        System.out.println(d1);
        System.out.println(d2);
    }

    /**
     * 使用String作为入参
     */
    private static void doubleTest3() {
        BigDecimal d1 = new BigDecimal("0.03");
        BigDecimal d2 = new BigDecimal("0.02");
        System.out.println(d1);
        System.out.println(d2);
    }

    /**
     * 使用BigDecimal.valueOf
     */
    private static void doubleTest4() {
        BigDecimal d1 = BigDecimal.valueOf(0.03);
        BigDecimal d2 = BigDecimal.valueOf(0.02);
        System.out.println(d1);
        System.out.println(d2);
    }

    /**
     * 等值比较
     */
    private static void equalsTest5() {
        BigDecimal d1 = new BigDecimal("0.03");
        BigDecimal d2 = new BigDecimal("0.030");
        System.out.println(d1.equals(d2));
        System.out.println(d1.compareTo(d2));
    }

    /**
     * 除法精度范围
     *
     * 对于除不尽的计算，需要指定精度范围
     *
     * https://my.oschina.net/u/3644969/blog/4927776
     */
    private static void divideTest6() {
        BigDecimal d1 = new BigDecimal("2.0");
        BigDecimal d2 = new BigDecimal("3.0");
        // 小数点后保留两位，四舍五入
        System.out.println(d1.divide(d2, 2, RoundingMode.HALF_UP));
    }

    /**
     * 科学计数法
     *
     * 当超过18位时，BigDecimal默认会使用科学计数法
     * 调用toPlainString，可以打印原始数据
     */
    private static void test7() {
        // BigDecimal d1 = new BigDecimal("1234567891234567890.123456789");
        BigDecimal d1 = BigDecimal.valueOf(1234567891234567890.123456789);
        System.out.println(d1);
        System.out.println(d1.toString());
        System.out.println(d1.toPlainString());
    }

}
