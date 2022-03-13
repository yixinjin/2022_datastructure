package com.imooc.datastructure.map;

public class TestTreeMap {

    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();

        String[] words = {"apple", "banana", "orange", "pineapple",
                "coconut", "walnut", "apple", "watermelon", "dragon fruit", "strawberry", "blueberry"};

        for (String word : words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }

        System.out.println(map.getSize());
        System.out.println(map.get("apple"));
        System.out.println(map.get("banana"));

        map.remove("apple");
        System.out.println(map.getSize());
        System.out.println(map.get("watermelon"));
    }
}
