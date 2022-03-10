package com.imooc.datastructure.linkedlist;

public class LinkedList<E> {

    private class Node{
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null);
    }

    public Node getHead() {
        return this.dummyHead.next;
    }

    public int getSize() {
        return this.size;
    }

    public void add(int index, E val) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, invalid index");
        }

        Node prev = dummyHead;
        Node newNode = new Node(val);
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;

        this.size++;
    }

    public void addFirst(E val) {
        this.add(0, val);
    }

    public void addLast(E val) {
        this.add(size, val);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, invalid index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public E getFirst() {
        return this.get(0);
    }

    public E getLast() {
        return this.get(size - 1);
    }

    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, invalid index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = val;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, invalid index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        this.size--;

        return delNode.data;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    public boolean isEmpty() {
        return this.dummyHead.next == null;
    }

    @Override
    public String toString() {
        Node cur = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.data);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
