package com.ttk.examplecase.stream;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {

        // 初始化学生数据
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

        // 分组（按班级）
        // Map<String, List<Person>> map2 = personList.stream().collect(Collectors.groupingBy(Person::getClassNo));

        // 转数组（按名称）
        // String[] strings = personList.stream().map(Person::getName).toArray(String[]::new);

        // 去重
        // List<Integer> list1 = personList.stream().map(Person::getId).distinct().collect(Collectors.toList());

        // 排序（按年龄，默认升序）
        // List<Person> list = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        // 排序, 降序
        // List<Person> list2 = personList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());

        // 转String
        // List<String> idStrList = personList.stream().map(item -> String.valueOf(item.getId())).collect(Collectors.toList());

        // 根据age排序，如果age相同，则根据id排序，默认升序，如果age或id为空的话会报空指针
        // List<Person> pList1 = personList.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getId)).collect(Collectors.toList());

        // 解决排序为空报错，使用Comparator.nullsFirst()（最小）、Comparator.nullsLast()（最大），会将空值视为最小或最大值
        List<Person> pList2 = personList.stream()
                .sorted(Comparator.comparing(Person::getAge, Comparator.nullsFirst(Integer::compareTo))
                .thenComparing(Person::getId, Comparator.nullsLast(Integer::compareTo)))
                .collect(Collectors.toList());


        // 初始化班级学生数据
        List<SchoolClass> schoolClassList = initSchoolClassData();

        // 嵌套list平铺对象（班级中学员对象平铺）
        List<Person> classPersonList = schoolClassList.stream()
                .filter(school -> !CollectionUtils.isEmpty(school.getPersonList()))
                .map(SchoolClass::getPersonList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // 嵌套list取属性平铺（班级中学员ID平铺）
        List<Integer> idList = schoolClassList.stream()
                .filter(school -> !CollectionUtils.isEmpty(school.getPersonList()))
                .map(SchoolClass::getPersonList)
                .flatMap(Collection::stream)
                .map(Person::getId)
                .collect(Collectors.toList());
    }

    /**
     * 初始化学生数据list
     * @return
     */
    private static List<Person> initData() {

        List<Person> personList = Lists.newArrayList();

        Person person1 = new Person(null, "张三", 18, "一班");
        Person person2 = new Person(3, "李四", 17, "二班");
        Person person3 = new Person(4, "王五", null, "三班");
        Person person4 = new Person(5, "赵六", 15, "二班");
        Person person5 = new Person(6, "孙七", 14, "一班");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        return personList;
    }

    /**
     * 初始化班级学生数据
     * @return
     */
    private static List<SchoolClass> initSchoolClassData() {

        List<SchoolClass> schoolClassList = Lists.newArrayList();

        List<Person> personList1 = Lists.newArrayList();

        List<Person> personList2 = Lists.newArrayList();

        Person person1 = new Person(1, "张三", 12, "一班");
        Person person2 = new Person(2, "李四", 11, "二班");
        Person person3 = new Person(3, "王五", 14, "三班");
        Person person4 = new Person(4, "赵六", 15, "二班");

        personList1.add(person1);
        personList1.add(person2);
        personList2.add(person3);
        personList2.add(person4);

        SchoolClass schoolClass1 = new SchoolClass();
        schoolClass1.setClassId(1);
        schoolClass1.setClassName("1班");
        schoolClass1.setPersonList(personList1);

        SchoolClass schoolClass2 = new SchoolClass();
        schoolClass2.setClassId(2);
        schoolClass2.setClassName("2班");
        schoolClass2.setPersonList(personList2);

        SchoolClass schoolClass3 = new SchoolClass();
        schoolClass3.setClassId(3);
        schoolClass3.setClassName("3班");

        schoolClassList.add(schoolClass1);
        schoolClassList.add(schoolClass2);
        schoolClassList.add(schoolClass3);

        return schoolClassList;
    }
}
