package com.ttk.cese.designpattern.behaviorpattern.observer;

// 飞书观察者
public class FeishuObserver implements Observer{

    @Override
    public void send(String message) {
        System.out.println("发送飞书通知：" + message);
    }

}
