package com.ttk.examplecase.designpattern.structuralmode.combination.demo3;

/**
 * Component抽象组件
 *
 * 抽象菜单组件
 */
public abstract class MenuComponent {

    /**
     * 新增菜单
     * @param menu
     */
    public void add(MenuComponent menu) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除菜单
     * @param menu
     */
    public void remove(MenuComponent menu) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取子菜单
     * @param i
     * @return
     */
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取菜单名称
     * @return
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取价格
     * @return
     */
    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    // 打印
    public abstract void print();
}