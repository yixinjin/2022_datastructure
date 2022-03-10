package com.imooc.datastructure.queue.array;

import com.imooc.datastructure.queue.Queue;
import com.imooc.datastructure.queue.array.ArrayQueue;

public class TestArrayQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
    }
}
