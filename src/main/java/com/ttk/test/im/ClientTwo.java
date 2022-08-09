package com.ttk.test.im;

public class ClientTwo {
    public static void main(String[] srgs){
        ClientThread ct = new ClientThread();
        Thread th = new Thread(ct);
        th.start();
    }
}
