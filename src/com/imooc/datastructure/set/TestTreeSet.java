package com.imooc.datastructure.set;

public class TestTreeSet {

    public static void main(String[] args) {

        String[] words = {"apple", "banana", "orange", "pineapple",
                "coconut", "walnut", "apple", "watermelon", "dragon fruit", "strawberry", "blueberry"};

        Set<String> bstSet = new TreeSet<>();

        for (String word : words) {
            bstSet.add(word);
        }
        System.out.println(bstSet.getSize());
    }
}
