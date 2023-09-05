package com.ttk.examplecase.designpattern.behaviorpattern.observer;

// 飞书观察者
public class DingDingObserver implements Observer{

    @Override
    public void send(String message) {
        System.out.println("发送钉钉通知：" + message);
    }

}
