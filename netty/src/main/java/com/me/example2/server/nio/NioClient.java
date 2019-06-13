package com.me.example2.server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open(new InetSocketAddress(8090));
            //channel.
            //channel.write()

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
