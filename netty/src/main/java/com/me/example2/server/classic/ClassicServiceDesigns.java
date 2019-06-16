package com.me.example2.server.classic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClassicServiceDesigns {

    public static void main(String[] args) {
        new Server().run();
    }

    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                byte[] input = new byte[100];
                socket.getInputStream().read(input);
                process(input);
                byte[] output = new byte[100];
                socket.getOutputStream().write(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private byte[] process(byte[] cmd) {
            System.out.println("处理输入：" + cmd.toString());
            return new byte[100];
        }
    }

    static class Server implements Runnable {
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(8090);
                while(!Thread.interrupted()) {
                    new Thread(new Handler(serverSocket.accept()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
