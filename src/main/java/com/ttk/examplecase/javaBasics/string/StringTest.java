package com.ttk.examplecase.javaBasics.string;

public class StringTest {
    public static void main(String[] args) {

        /**
         * String为什么不可变
         * 1. 可以节省内存空间
         * 2. 安全性
         */

        // 在内存中创建的值为Tom，并放入字符串常量池，使用name引用Tom
        String name = "Tom";

        // 不会在内存中新建一个值Tom，而是先去字符串常量池中检索，如果发现有Tom，使用secondName引用Tom
        String secondName = "Tom";

        // ==比较的是引用地址，两者引用地址一样，true
        System.out.println(name == secondName);

        // equals比较的是值，true
        System.out.println(name.equals(secondName));

        // new String不会将值存放在字符串常量池中，而是在常量池外开辟一个内存空间存放Mark
        String thirdName = new String("Mark");
        String fourthName = new String("Mark");

        // 内存地址不一样，false
        System.out.println(thirdName == fourthName);
        // 值一样，true
        System.out.println(thirdName.equals(fourthName));

        // 开吧新的内存空间存放Tom
        String nikeName = new String("Tom");

        // 内存地址不一样，false
        System.out.println(name == nikeName);
        // 值一样，true
        System.out.println(name.equals(nikeName));

    }
}
