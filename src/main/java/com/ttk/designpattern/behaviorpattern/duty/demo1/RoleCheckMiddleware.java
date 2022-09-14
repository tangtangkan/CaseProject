package com.ttk.designpattern.behaviorpattern.duty.demo1;

/**
 * 检查用户角色
 */
public class RoleCheckMiddleware extends Middleware {

    public boolean check(String email, String password) {

        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        return checkNext(email, password);
    }

}