package day4;

//修饰符类别 Interface 接口名｛｝
//Interface 一个接口可以继承多个接口
//接口中包含两部分内容：常量，抽象方法
//接口中所有方法都是公开的
//方法的public abstact可以省略
//常量的public static final可以省略
//类与类之间的关系：is,has
public class InterfaceTest {

    //public static final double pi = 3.1415;
    double pi = 3.1415;//可以省略public static final
}

class Animal {

}

interface Flyable{
    void fly();
}

class Cat  extends Animal implements  Flyable   { //extends 在前
    public void fly(){

    }
}