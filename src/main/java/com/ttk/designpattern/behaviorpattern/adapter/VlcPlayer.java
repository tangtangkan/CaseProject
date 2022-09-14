package com.ttk.designpattern.behaviorpattern.adapter;

/**
 * Vlc播放器
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("播放Vlc格式媒体，文件名称：" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // 在Mp4Player播放
    }
}