package com.imooc.datastructure.queue.linkedlist;

import com.imooc.datastructure.linkedlist.LinkedList;
import com.imooc.datastructure.queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    LinkedList<E> linkedList;

    public LinkedListQueue() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public E getFirst() {
        return linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.getSize() == 0;
    }

    @Override
    public String toString() {
        return "Front: " + linkedList.toString() + ": Tail";
    }
}
