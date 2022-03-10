package com.imooc.datastructure.array.generics;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Score: %d", this.name, this.score));
        return sb.toString();
    }

}
