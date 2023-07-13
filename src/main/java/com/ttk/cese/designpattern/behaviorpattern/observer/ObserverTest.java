package com.ttk.cese.designpattern.behaviorpattern.observer;

// 观察者模式测试类
public class ObserverTest {
    public static void main(String[] args) {

        // 创建通知观察者对象
        NoticeObserver noticeObserver = new NoticeObserver();

        // 注册观察者
        noticeObserver.registerObserver(new EmaillObserver());
        noticeObserver.registerObserver(new DingDingObserver());
        noticeObserver.registerObserver(new FeishuObserver());

        noticeObserver.noticeObserver("消息内容");

    }
}
