package com.imooc.datastructure.array.basic;

public class Array {

    private int size;
    private int[] data;

    public Array(int capacity) {
        this.data = new int[capacity];
    }

    // Default constructor, give capacity of 10
    public Array() {
        this.data = new int[10];
    }

    // Add element at the given index position
    public void add(int index, int e) {
        if (this.isFull()) {
            throw new IllegalArgumentException("Add failed, array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index is incorrect");
        }

        // 从最后一个元素开始，每一个向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // Add element at the first position
    public void addFirst(int e) {
        add(0, e);
    }

    // Add element at the last position
    public void addLast(int e) {
        add(size, e);
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index is incorrect");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index is incorrect");
        }
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i : data) {
            if (i == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeElement(int e) {
        int removeIndex = find(e);
        if (removeIndex == -1) return false;

        for (int i = removeIndex; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    // Remove element at index position
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Rmove failed, index is incorrect");
        }
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        return removed;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
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
