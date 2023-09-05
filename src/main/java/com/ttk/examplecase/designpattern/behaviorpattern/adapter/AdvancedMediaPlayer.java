package com.ttk.examplecase.designpattern.behaviorpattern.adapter;

/**
 * 高级媒体播放器接口
 */
public interface AdvancedMediaPlayer {

   // 播放vlc格式
   void playVlc(String fileName);

   // 播放mp4格式
   void playMp4(String fileName);

}