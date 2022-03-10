package com.imooc.datastructure.queue.array;

import com.imooc.datastructure.queue.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    // 循环队列中, 留出一个空位
    // 1. 空的判断 tail == front
    // 2. 满的判断 tail + 1 = front
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        data = (E[]) new Object[11];
    }

    @Override
    public void enqueue(E e) {
        // 如果满的话我们进行resize扩容
        if ((tail + 1) % data.length == front) {
            resize(2 * size);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        E deqVal = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return deqVal;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Empty queue");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return this.tail == this.front;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[2 * capacity + 1];

        for (int i = front, j = 0; i != tail; i = (i + 1) % data.length, j++) {
            newData[j] = data[i];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size %d \n", this.size));
        sb.append("Front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("] Tail");
        return sb.toString();
    }
}
