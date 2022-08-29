package com.ttk.test.designpattern.structuralmode.combination.demo3;

/**
 * Leaf叶节点对象
 *
 * 菜单项组件
 * 菜单项拥有名称和价格，可以打印，但是不支持添加、删除等操作
 */
public class MenuItem extends MenuComponent {

    // 名称
    private String name;

    // 价格
    private double price;

    // 父节点的引用
    private Menu menu;

    public MenuItem(String name, double price, Menu menu) {
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println(getName() + " -- " + getPrice());
    }
}