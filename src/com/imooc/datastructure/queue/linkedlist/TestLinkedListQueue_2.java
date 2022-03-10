package com.imooc.datastructure.queue.linkedlist;

public class TestLinkedListQueue_2 {

    public static void main(String[] args) {
        LinkedListQueue_2<Integer> llq_2 = new LinkedListQueue_2<>();
        for (int i = 0; i < 10; i += 2) {
            llq_2.enqueue(i);
        }
        System.out.println(llq_2);

        llq_2.dequeue();
        System.out.println(llq_2);

        llq_2.dequeue();
        System.out.println(llq_2);

        System.out.println(llq_2.getSize());
    }
}
