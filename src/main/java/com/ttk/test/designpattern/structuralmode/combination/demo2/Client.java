package com.ttk.test.designpattern.structuralmode.combination.demo2;

public class Client {

    public static void main(String[] args) {

        AbstractFile m1 = new MusicFile("尽头.mp3");
        AbstractFile m2 = new MusicFile("飘洋过海来看你.mp3");
        AbstractFile m3 = new MusicFile("曾经的你.mp3");
        AbstractFile m4 = new MusicFile("take me to your heart.mp3");

        AbstractFile v1 = new VideoFile("战狼2.mp4");
        AbstractFile v2 = new VideoFile("理想.avi");
        AbstractFile v3 = new VideoFile("琅琊榜.avi");

        AbstractFile i1 = new ImageFile("敦煌.png");
        AbstractFile i2 = new ImageFile("baby.jpg");
        AbstractFile i3 = new ImageFile("girl.jpg");

        AbstractFile aa = new Folder("aa");
        aa.add(i3);

        AbstractFile bb = new Folder("bb");
        bb.add(m4);
        bb.add(v3);

        AbstractFile top = new Folder("top");
        top.add(aa);
        top.add(bb);

        top.add(m1);
        top.add(m2);
        top.add(m3);
        top.add(v1);
        top.add(v2);
        top.add(i1);
        top.add(i2);

        top.print();
    }
}