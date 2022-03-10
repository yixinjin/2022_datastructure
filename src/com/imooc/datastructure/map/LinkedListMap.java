package com.imooc.datastructure.map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" + key.toString() + ", " + value.toString() + "}";
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
    }

    public void add(K key, V value) {
        Node newNode = new Node(key, value);
        newNode.next = this.dummyHead.next;
        this.dummyHead.next = newNode;
        this.size++;
    }

    public V remove(K key) {
        if (isEmpty()) return null;

        Node prev = this.dummyHead;
        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.key.equals(key)) {
                prev.next = cur.next;
                cur.next = null;
                size--;
                return cur.value;
            }
            cur = cur.next;
            prev = prev.next;
        }
        return null;
    }

    public void set(K key, V value) {
        if (isEmpty()) return;

        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
    }

    public V get(K key) {
        if (isEmpty()) return null;

        return this.getNode(key).value;
    }

    // 一个辅助函数，定义在内部使用，
    private Node getNode(K key) {
        if (isEmpty()) return null;

        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public boolean contains(K key) {
        if (isEmpty()) return false;

        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}