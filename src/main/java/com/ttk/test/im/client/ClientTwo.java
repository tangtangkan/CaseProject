package com.ttk.test.im.client;


/**
 * 客户端Two，每个用户的入口，每当有用户进入，会开辟一条线程
 */
public class ClientTwo {
    public static void main(String[] srgs) {
        ClientThread ct = new ClientThread();
        Thread th = new Thread(ct);
        th.start();
    }
}
