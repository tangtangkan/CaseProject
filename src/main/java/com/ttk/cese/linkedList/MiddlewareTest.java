package com.ttk.cese.linkedList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MiddlewareTest {
    public static void main(String[] args) {

        Middleware middleware = new Middleware();
        middleware.setValue(1);

        Middleware middleware2 = new Middleware();
        middleware2.setValue(2);

        Middleware middleware3 = new Middleware();
        middleware3.setValue(3);

        Middleware middleware4 = new Middleware();
        middleware4.setValue(4);

        Middleware[] middlewares = new Middleware[3];
        middlewares[0] = middleware2;
        middlewares[1] = middleware3;
        middlewares[2] = middleware4;

        Middleware link = Middleware.link(middleware, middlewares);
        System.out.println(link.getValue());
        System.out.println(link.getNext().getValue());
        System.out.println(link.getNext().getNext().getValue());
        System.out.println(link.getNext().getNext().getNext().getValue());

    }
}
