package day1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String one = scanner.nextLine();
        String two = scanner.nextLine();

        char[] oneChar = one.toLowerCase().toCharArray();
        char[] twoChar = two.toLowerCase().toCharArray();
        int num = 0;
        for (int i = 0, len = oneChar.length; i < len; i++) {

            if (oneChar[i] == 32
                    || (oneChar[i] >= 48
                    && oneChar[i] <= 57)
                    || (oneChar[i] >= 65.
                    && oneChar[i] <= 90)
                    || (oneChar[i] >= 97f
                    && oneChar[i] <= 122)) {

                if (oneChar[i] == twoChar[0]) num++;

            } else {

                System.out.print("输入不合法");
                return;
            }
        }
        System.out.print(num);
    }
}
