package day1;

public class SuperTest {

    public static void main(String[] args) {

        //new B();

        new B("a");
    }

}

class A {

    private String a ;

    public A() {
        System.out.println("this is A");
    }


}

class B extends A {

    public B() {
        //super();//默认第一行调用super()
        System.out.println("this is B");
    }

    public B(String b) {
        this();//第一行手动指定了this或super,默认的super将不生效
        System.out.println("this is B2");
    }

}

