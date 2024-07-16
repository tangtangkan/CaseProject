package com.ttk.examplecase.shangguigu;

import com.ttk.examplecase.stream.Person;

import java.util.HashSet;
import java.util.Set;

public class EqualsDemo {

    public static void main(String[] args) {

        String a = new String("a");
        String b = new String("a");
        System.out.println(a == b);
        System.out.println(a.equals(b));

        Set<String> set1 = new HashSet<>();
        set1.add(a);
        set1.add(b);
        System.out.println(set1.size());

        // ===================================

        Person person1 = new Person();
        person1.setAge(20);

        Person person2 = new Person();
        person2.setAge(30);

        System.out.println(person1 == person2);
        System.out.println(person1.equals(person2));

        Set<Person> set2 = new HashSet<>();
        set2.add(person1);
        set2.add(person2);
        System.out.println(set2.size());

        // false true 1 false false 2
    }

}
