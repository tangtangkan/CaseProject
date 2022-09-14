package com.ttk.designpattern.behaviorpattern.duty.demo1;

/**
 * 检查请求数量限制
 */
public class ThrottlingMiddleware extends Middleware {

    // 每分钟请求数
    private int requestPerMinute;

    private int request;

    // 当前时间
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("请求次数超过限制");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
    }
}