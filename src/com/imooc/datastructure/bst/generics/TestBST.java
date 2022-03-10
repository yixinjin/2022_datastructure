package com.imooc.datastructure.bst.generics;

public class TestBST {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(15); bst.add(55); bst.add(29); bst.add(58);
        bst.add(3); bst.add(40); bst.add(66); bst.add(38);

        bst.inOrder();

        System.out.println(bst.contains(55));
        System.out.println(bst.contains(3));
        System.out.println(bst.contains(22));

        System.out.println(bst.maximum());
        System.out.println(bst.minimum());

        bst.removeMin();
        bst.removeMax();
        bst.inOrder();

        bst.remove(38);
        bst.inOrder();
    }
}
