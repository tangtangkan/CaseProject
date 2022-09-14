package com.ttk.designpattern.creationmode.builder;

/**
 * 测试客户端
 */
public class BuilderTest {

    public static void main(String[] args) {

        // 模拟精准营销业务逻辑
        User jzyxUser = Director.getJzyxUser();
        System.out.println("精准营销获得的User对象为：" + jzyxUser);
        System.out.println("开始精准营销的业务逻辑");

        System.out.println();

        // 模拟刺激消费业务逻辑
        User cjxfUser = Director.getCjxfUser();
        System.out.println("刺激消费获得的User对象为：" + cjxfUser);
        System.out.println("开始刺激消费的业务逻辑");
    }

}
