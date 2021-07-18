package day3;

/**
 * 凡是双引号括起来的字符串都在方法区的常量池中
 * new对象都在堆开辟空间
 * */
public class StringTest {

    public static void main(String[] args) {

        //字面量赋值,s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1= "abc";
        String s2 = "abc";

        //三个对象“abc”，两个new
        //"abc"在方法区字符常量池
        //new 在堆中开辟空间存储“abc”方法区的地址
        //s3、s4在栈中开辟空间存储new堆空间的地址
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1==s2);

        //所以字符串比较要使用equals方法
        System.out.println(s3==s4);

    }
}
