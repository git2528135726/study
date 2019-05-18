package com.me.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchosSocketServer {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8192)) {//这个将自动关闭
            int i = 0;
            while(true){
                Socket socket = serverSocket.accept();//socket将不在这里关闭
                System.out.println("服务的连结数：" + (++i));
                Thread thread = new Thread(new ThreadedEchoHandler(socket));
                thread.start();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
