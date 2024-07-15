package com.ttk.examplecase.shangguigu;

import java.util.HashSet;
import java.util.Set;

public class HashCodeDemo {

    static class Book{
        int id;
    }

    public static void main(String[] args) {
        /**
         * 写一个
         */
        v2();
    }

    /**
     * 出现hash冲突，在第19423次，值是1471278212
     * 出现hash冲突，在第63390次，值是1187032365
     * 出现hash冲突，在第86149次，值是829798883
     * 99997
     */
    private static void v2() {

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 100000; i++) {
            int i1 = new Book().hashCode();
            if (!set.contains(i)) {
                set.add(i1);
            } else {
                System.out.println("出现hash冲突，在第" + i + "次，值是" + i1);
            }
        }
        System.out.println(set.size());
    }

    private static void v1() {
        // 不冲突
        System.out.println("AA".hashCode());
        System.out.println("BB".hashCode());
        System.out.println();

        // 冲突
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println();

        // 冲突
        System.out.println("柳柴".hashCode());
        System.out.println("柴柕".hashCode());
        System.out.println();
    }

}
