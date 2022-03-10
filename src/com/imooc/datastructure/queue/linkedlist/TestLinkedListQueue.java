package com.imooc.datastructure.queue.linkedlist;

public class TestLinkedListQueue {

    public static void main(String[] args) {
        LinkedListQueue<Integer> llq = new LinkedListQueue<>();
        for (int i = 0; i < 10; i += 2) {
            llq.enqueue(i);
        }
        System.out.println(llq);

        llq.dequeue();
        System.out.println(llq);

        llq.dequeue();
        System.out.println(llq);

        System.out.println(llq.getSize());
    }
}
