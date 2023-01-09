package com.ttk.cese.designpattern.structuralmode.bridging.demo1;

// 高级远程控制器
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}