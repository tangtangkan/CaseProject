package com.ttk.examplecase.im.client;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端子线程，每当接收和发送消息，会开辟线程用来同步
 */
public class ClientThread implements Runnable {

    @Override
    public void run() {
        Socket socket = null;
        try {
            //使用当前主机服务器，端口号设为8000
            socket = new Socket("localhost", 8000);
            Thread th_1 = new Thread(new ClientReceive(socket));
            th_1.start();
            Thread th_2 = new Thread(new ClientSend(socket));
            th_2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
