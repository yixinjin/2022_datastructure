package com.imooc.datastructure.array.basic;

public class TestArray {

    public static void main(String[] args) {
        Array arr = new Array();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.add(1, 10);
        arr.addFirst(100);
        arr.addLast(1100);
        arr.add(3, 900);
        arr.addLast(1200);
        arr.addLast(1300);
        arr.addLast(1400);
        System.out.println(arr);

        arr.remove(900);
        System.out.println(arr);

        arr.remove(1200);
        System.out.println(arr);

        arr.addLast(2000);
        System.out.println(arr);
    }
}
