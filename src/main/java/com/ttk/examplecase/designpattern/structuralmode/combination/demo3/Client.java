package com.ttk.examplecase.designpattern.structuralmode.combination.demo3;

public class Client {

    public static void main(String[] args) {

        Menu menu = new Menu("所有菜单");

        Menu menu1 = new Menu("子菜单1");
        Menu menu2 = new Menu("子菜单2");
        Menu menu3 = new Menu("子菜单3");

        // 给所有菜单添加三个子菜单
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        // 给第二个菜单添加一个菜单项和一个子菜单
        MenuItem menu4 = new MenuItem("菜单项4", 10.0, menu2);
        menu2.add(menu4);
        Menu menu5 = new Menu("子菜单5");
        menu2.add(menu5);

        menu5.add(new MenuItem("菜单项6", 20.0, menu5));
        menu5.add(new Menu("子菜单7"));

        //打印所有菜单
        menu.print();
    }

}