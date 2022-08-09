package com.ttk.test.im;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend implements Runnable{

    private Socket socket;

    public ClientSend(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //发送信息
        PrintStream ps = null;
        Scanner input = new Scanner(System.in);
        try {
            while(true) {
                //输入发送的信息(写)
                ps = new PrintStream(socket.getOutputStream());
                String msg = input.next();
                ps.println(msg);
                ps.flush();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
