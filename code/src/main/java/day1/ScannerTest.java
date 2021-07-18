package day1; /**
 * 从键盘获取不同类型的变量
 */
import  java.util.Scanner;

class ScannerTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int out = sc.nextInt();

        System.out.println(out);
    }
}