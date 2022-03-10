package com.imooc.datastructure.stack.array;

import com.imooc.datastructure.array.generics.Array;
import com.imooc.datastructure.stack.Stack;

public class ArrayStack<E> implements Stack<E> {

    // 底层存储结构，利用之前的创建的动态数组完成
    private Array<E> arr;
    private static int age = 0;

    public ArrayStack(int capacity) {
        this.arr = new Array(capacity);
    }

    // Default constructor，给10个元素
    public ArrayStack() {
        this.arr = new Array(10);
    }

    @Override
    public void push(E e) {
        this.arr.addLast(e);
    }

    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public E peek() {
        return arr.getLast();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Stack: size %d \n", this.getSize()));
        sb.append("[");
        for (int i = 0; i < arr.getSize(); i++) {
            sb.append(arr.get(i));
            if (i != arr.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] Top");
        return sb.toString();
    }
}
