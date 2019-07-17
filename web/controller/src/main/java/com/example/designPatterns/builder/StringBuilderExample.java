package com.example.designPatterns.builder;

/**
 * @author lazy cat
 * @since 2019-07-16
 **/
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