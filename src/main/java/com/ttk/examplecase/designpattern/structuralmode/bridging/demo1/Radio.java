package com.ttk.examplecase.designpattern.structuralmode.bridging.demo1;

// 收音机
public class Radio implements Device {

    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("收音机");
        System.out.println("开启状态：" + (on ? "enabled" : "disabled"));
        System.out.println("当前音量：" + volume + "%");
        System.out.println("当频道：" + channel);
        System.out.println("------------------------------------\n");
    }
}