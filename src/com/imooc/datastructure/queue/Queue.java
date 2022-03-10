package com.imooc.datastructure.queue;

public interface Queue<E> {

    public void enqueue(E e);
    public E dequeue();
    public int getSize();
    public E getFirst();
    public boolean isEmpty();
}
