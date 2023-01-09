package com.ttk.cese.im.client;

/**
 * 客户端One，每个用户的入口，每当有用户进入，会开辟一条线程
 */
public class ClientOne {
    public static void main(String[] srgs) {
        ClientThread ct = new ClientThread();
        Thread th = new Thread(ct);
        th.start();
    }
}
