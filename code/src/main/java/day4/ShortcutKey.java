package day4;

public class ShortcutKey {

    private String age;
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAgeAndName(String age,String name) {

    }

    public ShortcutKey() {
    }

    //psvm
    public static void main(String[] args) {

        //sout
        System.out.println();
        //Ctry + y 删除一行

        //alt + insert 新增、新建快捷键
        //alt + insert 可新增setter,getter方法

        ShortcutKey key = new ShortcutKey();

        //ctrl+p 提示参数
        key.setAgeAndName("23","23");

    }
}