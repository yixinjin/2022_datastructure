package com.imooc.datastructure.array.generics;

public class Array<E> {

    private int size;
    private E[] data;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    // Default constructor, give capacity of 10
    public Array() {
        this.data = (E[]) new Object[10];
    }

    // Add element at the given index position
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index is incorrect");
        }

        if (this.isFull()) {
            resize(2 * data.length);
        }

        // 从最后一个元素开始，每一个向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // Add element at the first position
    public void addFirst(E e) {
        add(0, e);
    }

    // Add element at the last position
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index is incorrect");
        }
        return data[index];
    }

    public E getFirst() {
        return this.get(0);
    }

    public E getLast() {
        return this.get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index is incorrect");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (E i : data) {
            if (i.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeElement(E e) {
        int removeIndex = find(e);
        if (removeIndex == -1) return false;

        remove(removeIndex);
        return true;
    }

    // Remove element at index position
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, index is incorrect");
        }
        E removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        // 缩容的话，data.length要大于1才能缩，要不然data.length/2 = 0 就不对了
        if (size == data.length / 4 && data.length > 1) {
            resize(data.length / 2);
        }

        return removed;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // Return if the array is full
    public boolean isFull() {
        return this.size != 0 && this.size == this.data.length;
    }

    // Return if the array is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Return capacity of the array
    public int getCapacity() {
        return this.data.length;
    }

    // Return the current size of the array
    public int getSize() {
        return this.size;
    }

    // Resize the array
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
