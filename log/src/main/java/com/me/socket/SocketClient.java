package com.me.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/*
1、InputStream、OutputStream 均实现了Closeable接口
InputStream is = null;
OutputStream os = null;
try {
	//...
} catch (IOException e) {
	//...
}finally{
	try {
		if(os!=null){
			os.close();
		}
		if(is!=null){
			is.close();
		}
	} catch (IOException e2) {
		//...
	}
}
2、使用try(){}catch(){}后，方便许多
try(
	InputStream is = new FileInputStream("...");
	OutputStream os = new FileOutputStream("...");
){
	//...
}catch (IOException e) {
	//...
}
 */
//服务端将主动关闭Socket
public class SocketClient {

    public static void main(String[] args) {

        try(Socket socket = new Socket("time-A.timefreq.bldrdoc.gov",13)) {//jdk1.7语法

            InputStream in = socket.getInputStream();

            Scanner scanner = new Scanner(in);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
