package com.ttk.examplecase.designpattern.creationmode.builder;

/**
 * 导演类
 */
public class Director {

    // 为精准营销提供获取User的方法
    public static User getJzyxUser() {
        IUserBuilder userBuilder = new UserBuilder("360");
        return userBuilder.getUser();
    }

    // 为刺激消费提供获取User的方法
    public static User getCjxfUser() {
        IUserBuilder userBuilder = new UserBuilder("30");
        return userBuilder.getUser();
    }
}