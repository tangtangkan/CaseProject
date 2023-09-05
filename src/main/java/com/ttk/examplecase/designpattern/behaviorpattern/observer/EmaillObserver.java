package com.ttk.examplecase.designpattern.behaviorpattern.observer;

// 邮件观察者
public class EmaillObserver implements Observer{

    @Override
    public void send(String message) {
        System.out.println("发送邮件通知：" + message);
    }

}
