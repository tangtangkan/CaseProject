package com.ttk.examplecase.designpattern.behaviorpattern.duty.demo1;

/**
 * 检查用户登录信息
 */
public class UserExistsMiddleware extends Middleware {

    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("email没有登记");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("密码错误");
            return false;
        }
        return checkNext(email, password);
    }
}