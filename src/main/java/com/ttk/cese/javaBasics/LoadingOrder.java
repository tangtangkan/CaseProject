package com.ttk.cese.javaBasics;

/**
 * 加载顺序
 * Java多态--子类对象指向父类引用
 * https://blog.csdn.net/wenqi1992/article/details/125273513
 */
public class LoadingOrder {

    public static void main(String[] args) {

        // 子类对象指向父类引用
        Sub sub = new Sub();

        // 调用对象的方法
        sub.method();

        // 调用对象的属性
        System.out.println(sub.name);

    }

    static class Fu {
        private String name = "fu";

        static {
            System.out.println("this is fu static block");
        }

        {
            System.out.println("this is fu common block");
        }

        public Fu() {
            System.out.println("this is fu constructor");
        }

        public void method() {
            System.out.println("this is fu");
        }
    }

    static class Sub extends LoadingOrder.Fu {
        private String name = "sub";

        static {
            System.out.println("this is sub static block");
        }

        {
            System.out.println("this is sub common block");
        }

        public Sub() {
            System.out.println("this is sub constructor");
        }

        public void method() {
            System.out.println("this is sub");
        }
    }

}
