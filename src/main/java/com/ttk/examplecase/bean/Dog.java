package com.ttk.examplecase.bean;

public class Dog {

    private String name;

    public Dog() {
        // 默认是在无参构造方法中实例化
        System.out.println("1.实例化");
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 属性赋值就是设置值
        System.out.println("2.属性赋值");
        this.name = name;
    }

    public void myInit() {
        // 初始化方法需要自己定义, 并且在xml中进行配置
        System.out.println("3.初始化");
    }

    public void myDestroy() {
        // 实例销毁方法需要自己定义, 并且在xml中进行配置
        System.out.println("5.实例销毁");
    }


}
