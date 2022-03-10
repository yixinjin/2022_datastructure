package com.imooc.datastructure.queue.linkedlist;

import com.imooc.datastructure.queue.Queue;

public class LinkedListQueue_2<E> implements Queue<E> {

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node node) {
            this.data = data;
            this.next = node;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            this.head = new Node(e);
            this.tail = this.head;
            return;
        }

        this.tail.next = new Node(e);
        this.tail = this.tail.next;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue failed, queue is empty");
        }

        Node retNode = this.head;
        this.head = this.head.next;
        retNode.next = null;
        size--;
        return retNode.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Get first failed, queue is empty");
        }

        return this.head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Head: ");

        Node tmp = this.head;
        while(tmp != null) {
            sb.append(tmp.data);
            sb.append("->");
            tmp = tmp.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
