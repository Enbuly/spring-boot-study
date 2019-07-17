package com.example.studyDemo.builder;

public class StringBuilderExample extends AbstractStringBuilder {

    public StringBuilderExample() {
        super(16);
    }

    @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }
}
