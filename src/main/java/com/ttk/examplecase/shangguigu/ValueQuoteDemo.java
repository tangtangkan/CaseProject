package com.ttk.examplecase.shangguigu;

import com.ttk.examplecase.stream.Person;

public class ValueQuoteDemo {

    public static void changeValue1(int age) {
        age = 30;
    }

    public static void changeValue2(Person p) {
        p.setAge(30);
    }

    public static void changeValue3(String name) {
        name = "李四";
    }

    private static int age1 = 20;

    public static void main(String[] args) {

        int age = 20;
        changeValue1(20);
        System.out.println(age);

        changeValue1(age1);
        System.out.println(age1);

        // Person：类模板，在方法区
        // person：引用、指针，在栈中
        // new Person()：实例，在堆中
        Person person = new Person();
        person.setAge(20);
        changeValue2(person);
        System.out.println(person.getAge());

        String name = "张三";
        changeValue3(name);
        System.out.println(name);

        // 20 20 30 张三
    }

}
