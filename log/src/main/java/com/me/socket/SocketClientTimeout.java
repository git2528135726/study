package com.me.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClientTimeout {

    public static void main(String[] args) {

            //Socket socket = new Socket(host,port)将无法设置超时
            try(Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13), 1000);

            }catch (IOException e) {
                e.printStackTrace();
            }

    }
}
