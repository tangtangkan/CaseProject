package com.ttk.cese.im.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 服务器创建入口
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建一个服务器，端口号为8000
        ServerSocket server = new ServerSocket(8000);
        System.out.println("创建一个服务器，端口号为8000");
        // 创建一个死循环，让服务器一直处于监听客户端信息的状态
        while (true) {
            System.out.println("客户端连接进来了...");
            Socket socket = server.accept();
            // 传入监听到的socket，并且启动线程
            ServerThread st = new ServerThread(socket);
            Thread th = new Thread(st);
            th.start();
            // 异常未处理
        }
    }
}
