package com.imooc.datastructure.array.generics;

public class TestArray {

    public static void main(String[] args) {
        Student st1 = new Student("Peter", 99);
        Student st2 = new Student("Wong", 90);
        Student st3 = new Student("Lee", 80);
        Student st4 = new Student("Charly", 94);
        Student st5 = new Student("Branden", 82);

        Array<Student> arr = new Array(2);

        arr.addFirst(st1);
        arr.addFirst(st2);
        arr.addLast(st3);
        arr.addFirst(st4);
        arr.addLast(st5);
        System.out.println(arr);
    }
}
