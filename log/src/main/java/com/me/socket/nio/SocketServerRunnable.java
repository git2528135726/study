
package com.me.socket.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketServerRunnable implements Runnable {

    private SocketChannel socketChannel;
    private String tag;

    public SocketServerRunnable(SocketChannel serverSocketChannel, String tag) {
        this.socketChannel = serverSocketChannel;
        this.tag = tag;
    }

    public void run() {
        long start = System.currentTimeMillis();
        try {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.clear();
            int readNum = socketChannel.read(buffer);
            //System.out.println(tag + " receive: " + ConvertUtil.convertByteBufferToString(buffer));
            buffer.rewind();
            socketChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(tag + " time: " + (System.currentTimeMillis() - start));
        }
    }
}