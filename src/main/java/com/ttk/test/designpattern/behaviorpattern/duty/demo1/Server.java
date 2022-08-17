package com.ttk.test.designpattern.behaviorpattern.duty.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权目标
 */
public class Server {

    private Map<String, String> users = new HashMap<>();

    private Middleware middleware;

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {

            System.out.println("登录成功");

            return true;
        }
        return false;
    }

    // 登记
    public void register(String email, String password) {
        users.put(email, password);
    }

    // 是否包含email
    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    // email和password是否对应
    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}