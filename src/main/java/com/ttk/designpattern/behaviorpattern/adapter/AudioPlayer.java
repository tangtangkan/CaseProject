package com.ttk.designpattern.behaviorpattern.adapter;

/**
 * 音频播放器
 */
public class AudioPlayer implements MediaPlayer {

    // 媒体适配器
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        // 播放mp3音乐文件的内置支持
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("播放mp3音频, 文件名称：" + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            // mediaAdapter 提供了播放其他文件格式的支持
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("不支持播放其他格式音频，文件名称：" + audioType);
        }
    }
}