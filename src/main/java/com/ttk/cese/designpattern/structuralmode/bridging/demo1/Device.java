package com.ttk.cese.designpattern.structuralmode.bridging.demo1;

// 所有设备的通用接口
public interface Device {

    // 是否开启
    boolean isEnabled();

    // 开启
    void enable();

    // 关闭
    void disable();

    // 获取体积
    int getVolume();

    // 设置体积
    void setVolume(int percent);

    // 获取频道
    int getChannel();

    // 设置频道
    void setChannel(int channel);

    // 打印状态
    void printStatus();
}