package com.imooc.datastructure.linkedlist;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();

        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addFirst(40);
        System.out.println(linkedList);

        linkedList.set(2, 99);
        System.out.println(linkedList);

        Integer getVal = linkedList.get(3);
        System.out.println(getVal);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
