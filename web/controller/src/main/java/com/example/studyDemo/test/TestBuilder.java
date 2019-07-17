package com.example.studyDemo.test;

import com.example.studyDemo.builder.StringBuilderExample;

public class TestBuilder {

    public static void main(String[] args) {
        StringBuilderExample sb = new StringBuilderExample();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            sb.append((char) ('a' + i));
        }
        System.out.println(sb.toString());
    }
}
