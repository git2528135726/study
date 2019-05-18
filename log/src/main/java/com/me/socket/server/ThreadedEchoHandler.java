package com.me.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable {

    private Socket socket;

    public ThreadedEchoHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try{

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            PrintWriter printWriter = new PrintWriter(outputStream,true);//自动刷出
            printWriter.println("Server Echo:" + socket.getInetAddress().getHostName());

            try(Scanner scanner = new Scanner(inputStream)) {

                boolean done = true;
                while(done && scanner.hasNext()) {

                    String line = scanner.nextLine();
                    printWriter.println("Server Echo: "+ line);
                    if(line.trim().equals("BYE")) done = false;
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
