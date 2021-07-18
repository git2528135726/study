package day4;


//final可以修饰变量、类、方法
//被final修饰的类，不能被继承
//被final修饰的方法，不能被覆盖
//被final修饰的局部变量，一旦被初始化不能被重新赋值（方法区字面量）
//final修饰类变量，类引用初始化后不能修改，类内部可以修改
//final修饰成员变量必须被初始化，构造函数或直接赋值
//static final 联合修饰的变量称为“常量”。常量名建议全部大写，每个单词之间采用下划线衔接
//  常量：实际上常量和静态变量一样，区别在于：常量的值不能变，常量一般公开的public
//  常量和静态变量， 都是存储在方法区，并且都是在类加载时初始化

public class FinalTest {

    public static void main(String[] args) {
        final String s;

    }


}
