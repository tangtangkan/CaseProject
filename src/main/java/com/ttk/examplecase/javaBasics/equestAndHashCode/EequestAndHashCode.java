package com.ttk.examplecase.javaBasics.equestAndHashCode;

import java.util.HashSet;

public class EequestAndHashCode {

    public static void main(String[] args) {

        HashSet<Person> personHashSet = new HashSet<>();
        personHashSet.add(new Person("张三"));
        personHashSet.add(new Person("张三"));
        personHashSet.add(new Person("张三"));

        System.out.println("personHashSet共有" + personHashSet.size() + "条数据，内容：" + personHashSet);

        HashSet<Dog> dogHashSet = new HashSet<>();
        dogHashSet.add(new Dog("滚子"));
        dogHashSet.add(new Dog("滚子"));
        dogHashSet.add(new Dog("滚子"));

        System.out.println("dogHashSet共有" + dogHashSet.size() + "条数据，内容：" + dogHashSet);

    }

}
