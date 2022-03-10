package com.imooc.datastructure.set;

public class TreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree bst;

    public TreeSet() {
        bst = new BinarySearchTree();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty set, cannot remove");
        }
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
