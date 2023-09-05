package com.ttk.examplecase.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pig implements BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    public Pig() {
        // 默认是在无参构造方法中实例化
        System.out.println("1.实例化");
    }

    public Pig(String name) {
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
        System.out.println("6.初始化");
    }

    public void myDestroy() {
        // 实例销毁方法需要自己定义, 并且在xml中进行配置
        System.out.println("10.实例销毁");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("3.Aware方法执行：" + s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.执行InitializingBean中afterPropertiesSet方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9.执行DisposableBean中destroy方法");
    }
}
