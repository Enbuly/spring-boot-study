package com.example.studyDemo.builder;

import java.util.Arrays;

/**
 * @author lazy cat
 * @since 2019-07-16
 **/
public class AbstractStringBuilder {

    char[] value;

    int count;

    AbstractStringBuilder(int capacity) {
        count = 0;
        value = new char[capacity];
    }

    public void append(char c) {
        ensureCapacityInternal(count + 1);
        value[count++] = c;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0)
            expandCapacity(minimumCapacity);
    }

    private void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0)
            newCapacity = minimumCapacity;
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}