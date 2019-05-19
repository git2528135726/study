package com.me.example2.server.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioServiceDesigns {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8090));
        serverSocketChannel.configureBlocking(false);
        //将上文配置好的channel注册到selector上
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(null);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while(iterator.hasNext()) {
                SelectionKey selectionKey1 = iterator.next();
                if (selectionKey1.isAcceptable()) {
                    SelectableChannel selectableChannel = selectionKey1.channel();
                    selectableChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                }else if(selectionKey1.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey1.channel();
                    ByteBuffer readBufs = ByteBuffer.allocate(100);
                    long length = socketChannel.read(readBufs);
                    System.out.println("服务器读：" + readBufs);
                }else if(selectionKey1.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey1.channel();
                    ByteBuffer writeBuffer = ByteBuffer.wrap("服务器返回".getBytes());
                    socketChannel.write(writeBuffer);
                }
                selectionKeySet.remove(selectionKey1);
            }
        }

    }
}
