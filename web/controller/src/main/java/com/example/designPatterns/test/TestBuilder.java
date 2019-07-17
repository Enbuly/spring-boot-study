package com.example.designPatterns.test;

import com.example.designPatterns.builder.StringBuilderExample;

/**
 * @author lazy cat
 * @since 2019-07-16
 **/
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