package com.ttk.cese.designpattern.structuralmode.bridging.demo1;

// 所有远程控制器的通用接口
public interface Remote {

    // 开启
    void power();

    // 减音
    void volumeDown();

    // 加音
    void volumeUp();

    // 频道-
    void channelDown();

    // 频道+
    void channelUp();
}