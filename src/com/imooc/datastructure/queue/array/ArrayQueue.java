package com.imooc.datastructure.queue.array;

import com.imooc.datastructure.array.generics.Array;
import com.imooc.datastructure.queue.Queue;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> dataArr;

    public ArrayQueue(int capacity) {
        dataArr = new Array<>(capacity);
    }

    public ArrayQueue() {
        dataArr = new Array<>(10);
    }

    @Override
    public void enqueue(E e) {
        dataArr.addLast(e);
    }

    @Override
    public E dequeue() {
        return dataArr.removeFirst();
    }

    @Override
    public int getSize() {
        return dataArr.getSize();
    }

    @Override
    public E getFirst() {
        return dataArr.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return dataArr.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size %d \n", this.getSize()));
        sb.append("[");
        for (int i = 0; i < dataArr.getSize(); i++) {
            sb.append(dataArr.get(i));
            if (i != dataArr.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] Tail");
        return sb.toString();
    }
}
