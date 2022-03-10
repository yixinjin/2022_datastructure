package com.imooc.datastructure.map;

public interface Map <K, V>{

    // 对数据结构基本操作就是增删改查
    void add(K key, V value);
    V remove(K key);
    void set(K key, V value);
    boolean contains(K key);
    V get(K key);
    int getSize();
    boolean isEmpty();
}
