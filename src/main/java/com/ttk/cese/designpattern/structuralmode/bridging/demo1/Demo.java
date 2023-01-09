package com.ttk.cese.designpattern.structuralmode.bridging.demo1;

// 客户端
public class Demo {

    public static void main(String[] args) {
        testDevice(new Tv());
        // testDevice(new Radio());
    }

    public static void testDevice(Device device) {

        System.out.println("测试基础远程控制器");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        // System.out.println("测试高级远程控制器");
        // AdvancedRemote advancedRemote = new AdvancedRemote(device);
        // advancedRemote.power();
        // advancedRemote.mute();
        // device.printStatus();
    }
}