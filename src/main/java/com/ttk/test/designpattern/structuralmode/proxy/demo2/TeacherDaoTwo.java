package com.ttk.test.designpattern.structuralmode.proxy.demo2;

/**
 * 目标对象
 */
public class TeacherDaoTwo implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("TeacherDaoTwo老师授课中...");
    }

}
