package com.me.aync.client;

public class ArrayExer1 {
    public static void main(String[] args) {

        int[] arr = new int[] {8, 2, 1, 0, 9, 5};
        int[] index = new int[] {2, 4, 0, 2, 1 ,3, 3, 3, 1 ,5, 3};
        String tel = "";

        for(int i=0; i < index.length; i++) {
            tel += arr[index[i]];
        }
        System.out.println("联系方式" + tel);
    }
}
