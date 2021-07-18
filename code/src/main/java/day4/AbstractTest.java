package day4;

public class AbstractTest {
}

//抽象方法必须出现在抽象类中
abstract class Account {
    public Account(String a) {

    }

    public abstract void draw();
}

class CreditAccount extends Account {

    public CreditAccount(String a) {
        super(a);//这里必须
    }

    public void draw() {

    }
}


