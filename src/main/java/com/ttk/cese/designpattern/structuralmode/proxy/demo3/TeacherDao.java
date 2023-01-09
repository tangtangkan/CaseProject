package com.ttk.cese.designpattern.structuralmode.proxy.demo3;

/**
 * 目标类
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("老师授课中...");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello: " + name);
    }
}