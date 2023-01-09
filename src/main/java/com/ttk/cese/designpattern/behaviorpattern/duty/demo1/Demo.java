package com.ttk.cese.designpattern.behaviorpattern.duty.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static Server server;

    /**
     * 初始化服务
     */
    private static void init() {
        server = new Server();
        server.register("aa@qq.com", "123");
        server.register("bb@qq.com", "456");

        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {

        init();

        boolean success;

        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}