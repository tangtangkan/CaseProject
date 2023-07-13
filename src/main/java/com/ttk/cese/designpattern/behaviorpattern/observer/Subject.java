package com.ttk.cese.designpattern.behaviorpattern.observer;

// 通知主题接口
public interface Subject {

    // 注册观察者
    void registerObserver(Observer observer);

    // 删除观察者
    void removeObserver(Observer observer);

    // 通知观察者
    void noticeObserver(String message);

}
