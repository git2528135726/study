package day1;


import java.util.Scanner;

public class LastStringLength {

    public static  void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        String in = scanner.nextLine();

        String[] arrIn = in.split(" ");

        int length = arrIn.length;
        String last = arrIn[length-1];

        int length2 = last.length();


        System.out.print(length2);
    }

}
