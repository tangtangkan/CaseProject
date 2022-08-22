package com.ttk.test.designpattern.structuralmode.proxy.demo2;

/**
 * 静态代理
 * 与目标对象实现同一个接口
 */
public class TeacherDaoProxy implements ITeacherDao {

    // 通过接口来聚合
    private ITeacherDao target;

    //构造器
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        // 方法
        System.out.println("开始代理...");
        target.teach();
        System.out.println("代理提交...");
    }
}

