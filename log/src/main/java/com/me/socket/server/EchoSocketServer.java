package com.me.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 只能服务于一个客户端
 */
public class EchoSocketServer {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8189)) {

            try(Socket socket = serverSocket.accept())
            {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                try(Scanner scanner = new Scanner(inputStream)) {

                    PrintWriter out = new PrintWriter(outputStream,true);
                    out.println("Hello! Enter BYE to exit.");

                    boolean done = false;
                    while (!done && scanner.hasNext()) {
                        String line = scanner.nextLine();
                        out.println("Echo:" + line);
                        if(line.trim().equals("BYE")) done = true;
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
