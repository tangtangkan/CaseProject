package com.ttk.cese.designpattern.structuralmode.combination.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite组合节点对象
 *
 * 菜单组件
 * 菜单组件有菜单名和子菜单，但没有价格，支持添加、删除和打印等操作
 */
public class Menu extends MenuComponent {

    // 子菜单
    private List<MenuComponent> menuList = new ArrayList<>();

    // 菜单名
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent menu) {
        menuList.add(menu);
    }

    @Override
    public void remove(MenuComponent menu) {
        menuList.remove(menu);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuList.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("------");
        System.out.println(getName());
        // 打印所有子菜单
        for (MenuComponent menu : menuList) {
            menu.print();
        }
        System.out.println("======" + getName() + "结束");
    }
}