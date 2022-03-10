package com.imooc.datastructure.stack.array;

import com.imooc.datastructure.stack.array.ArrayStack;

public class TestArrayStack {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }
}
