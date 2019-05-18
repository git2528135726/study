package com.me.logs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 *未被任何变量引用的日志记录器可能被垃圾回收，用静态变量存储日志
 */

public class JUL {

    public static void main(String[] args) {
        //-Djava.util.logging.config.file=logging.properties MainClass
        System.setProperty("java.util.logging.config.file",JUL.class.getResource("/").getPath()+"logging.properties");

        //所有在java.io中的类都将相对路径名解释为以用户工作目录开始，可以通过System.getProperty("user.dir")来查看
        //System.out.println(System.getProperty("user.dir"));
        /*try {
            InputStream in = new FileInputStream((JUL.class.getResource("/").getPath()+"logging.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        Logger logger = Logger.getLogger("JUL");

        logger.info("this is JUL info log");

        logger.fine("this is JUL fine 级日志");

    }

}
