package com.ttk.test.designpattern.structuralmode.adapter;

public class Demo {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "稻香");
        audioPlayer.play("mp4", "绿巨人");
        audioPlayer.play("vlc", "闯");
        audioPlayer.play("mp5", "侠客");
    }

}
