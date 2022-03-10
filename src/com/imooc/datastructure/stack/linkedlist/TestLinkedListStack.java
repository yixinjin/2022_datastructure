package com.imooc.datastructure.stack.linkedlist;

public class TestLinkedListStack {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }
}
