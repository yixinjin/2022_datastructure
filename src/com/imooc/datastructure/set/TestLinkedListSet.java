package com.imooc.datastructure.set;

public class TestLinkedListSet {

    public static void main(String[] args) {

        String[] words = {"apple", "banana", "orange", "pineapple",
                "coconut", "walnut", "apple", "watermelon", "dragon fruit", "strawberry", "blueberry"};

        Set<String> linkedListSet = new LinkedListSet<>();

        for (String word : words) {
            linkedListSet.add(word);
        }
        System.out.println(linkedListSet.getSize());
        System.out.println(linkedListSet.contains("banana"));

        linkedListSet.remove("banana");
        System.out.println(linkedListSet.getSize());
        System.out.println(linkedListSet.contains("banana"));
    }

}
