package com.ttk.test.im.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 * 服务器子线程端
 */
public class ServerThread implements Runnable {

    private static LinkedList<Socket> list = new LinkedList<>();
    private Socket socket;

    public ServerThread(Socket socket) {
        // 把监听到的socket传过来
        this.socket = socket;
        // 并且添加到集合中
        list.add(socket);
    }

    @Override
    public void run() {
        // 接收客户端发过来的消息(读)
        // 为了提高读写效率,把字节流用转换流转换为字符流
        // 然后用缓存流封装转换流
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                sendAll(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 发送给所有人
    public void sendAll(String msg) {
        // 遍历集合，然后发送给集合(群)里面的所有人
        PrintStream ps = null;
        for (Socket sk : list) {
            try {
                ps = new PrintStream(sk.getOutputStream());
                ps.println(msg);
                ps.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
