package com.imooc.datastructure.map;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    BinarySearchTree<K, V> bst;

    public TreeMap() {
        this.bst = new BinarySearchTree<>();
    }

    @Override
    public void add(K key, V value) {
        bst.add(key, value);
    }

    @Override
    public V remove(K key) {
        V removeVal = bst.get(key);
        bst.remove(key);
        return removeVal;
    }

    @Override
    public void set(K key, V value) {
        bst.set(key, value);
    }

    @Override
    public boolean contains(K key) {
        return bst.contains(key);
    }

    @Override
    public V get(K key) {
        return bst.get(key);
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
