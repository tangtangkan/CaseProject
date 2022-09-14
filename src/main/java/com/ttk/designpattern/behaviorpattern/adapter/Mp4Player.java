package com.ttk.designpattern.behaviorpattern.adapter;

/**
 * Mp4播放器
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // 在VlcPlayer播放
    }

    @Override
    public void playMp4(String fileName) {
       System.out.println("播放Mp4格式媒体，文件名称：" + fileName);
    }
}