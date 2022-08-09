package com.ttk.test.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> personList = initData();

        // list转map, 当id重复时, 报错
        // Map<Integer, Person> map1 = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        // 当id重复时, 取第一个数据
        // Map<Integer, Person> map11 = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity(), (key1, key2) -> key1));

        // 当id重复时, 后面的数据覆盖前面的数据
        // Map<Integer, Person> map11 = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity(), (key1, key2) -> key2));

        // 返回对象某个属性作为value, 取第一个数据
        // Map<Integer, String> map11 = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key1));

        // 返回对象某个属性作为value, 后面的数据覆盖前面的数据
        // Map<Integer, String> map11 = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key2));

        // 分组
        // Map<String, List<Person>> map2 = personList.stream().collect(Collectors.groupingBy(Person::getClassNo));

        // 排序
        // List<Person> list = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        // 转数组
        // String[] strings = personList.stream().map(Person::getName).toArray(String[]::new);

        // 去重
        // List<Integer> list1 = personList.stream().map(Person::getId).distinct().collect(Collectors.toList());

        // 排序, 默认升序
        // List<Person> list2 = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        // 排序, 降序
        // List<Person> list2 = personList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());



        // for (int i = 0; i < list2.size(); i++) {
        //     System.out.println(list2.get(i).getAge());
        // }

    }





    private static List<Person> initData() {

        List<Person> personList = Lists.newArrayList();

        Person person1 = new Person(1, "张三", 12, "一班");
        Person person2 = new Person(2, "李四", 11, "二班");
        Person person3 = new Person(3, "王五", 14, "三班");
        Person person4 = new Person(4, "赵六", 15, "二班");
        Person person5 = new Person(1, "孙七", 10, "一班");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        return personList;



    }
}
