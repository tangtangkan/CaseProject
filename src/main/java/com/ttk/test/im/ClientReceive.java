package com.ttk.test.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive implements Runnable{

    private Socket socket;

    public ClientReceive(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        String msg = null;
        //接收信息(读)
        try {
            while(true) {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while((msg = br.readLine()) != null) {
                    System.out.println(msg);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
