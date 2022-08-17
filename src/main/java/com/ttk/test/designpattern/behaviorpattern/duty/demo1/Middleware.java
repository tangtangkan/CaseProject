package com.ttk.test.designpattern.behaviorpattern.duty.demo1;

/**
 * 基础验证接口
 */
public abstract class Middleware {

    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * 子类将通过具体检查实现此方法
     */
    public abstract boolean check(String email, String password);

    /**
     * 对链中的下一个对象运行检查
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}