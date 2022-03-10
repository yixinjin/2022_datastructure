package com.imooc.datastructure.bst;


import java.util.ArrayList;
import java.util.Random;

public class TestBST {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(50); bst.add(43); bst.add(38); bst.add(49);
        bst.add(53); bst.add(56); bst.add(52); bst.add(19);

        bst.inOrderTraverse();

        System.out.println(bst.contains(50));
        System.out.println(bst.contains(19));
        System.out.println(bst.contains(20));

        bst.preOrderNonRec();
        bst.preOrderTraverse();

        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());

        bst.removeMin();
        bst.inOrderTraverse();

        bst.removeMax();
        bst.inOrderTraverse();

        bst.levelOrderTraverse();

        bst.remove(53);
        bst.inOrderTraverse();

        bst.remove(50);

        bst.inOrderTraverse();

////        bst.preorder();
////        bst.preorderNonRec();
////


////
////        bst.levelOrder();
////
////        System.out.println(bst.contains(20));
////        System.out.println(bst.contains(49));
//
//        int n = 1000;
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            bst.add(random.nextInt(10000));
//        }
//
//        ArrayList<Integer> arrList = new ArrayList();
//        while(!bst.isEmpty()) {
//            arrList.add(bst.removeMin());
//        }
//
//        for (int v : arrList) {
//            System.out.print(v + " ");
//        }
//
//        for (int i = 1; i < arrList.size(); i++) {
//            if (arrList.get(i - 1) > arrList.get(i)) {
//                System.out.println(arrList.get(i - 1));
//                System.out.println(arrList.get(i));
//                System.out.println(i);
//                throw new IllegalArgumentException("Invalid!");
//            }
//        }
    }
}
