package com.ttk.test.designpattern.structuralmode.proxy.demo4;

public class TeacherDao {

	public String teach() {
		System.out.println("老师授课中, 我是cglib代理, 不需要实现接口");
		return "hello";
	}

}
