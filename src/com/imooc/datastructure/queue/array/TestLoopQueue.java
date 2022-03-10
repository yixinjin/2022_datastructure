package com.imooc.datastructure.queue.array;

import com.imooc.datastructure.queue.array.LoopQueue;

public class TestLoopQueue {

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);

        for (int i = 0; i < 3; i++) {
            loopQueue.dequeue();
        }
        loopQueue.enqueue(100);
        System.out.println(loopQueue);
    }
}
