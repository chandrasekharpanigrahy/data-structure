package com.example.stream.api.service.datastructure;

// LIFO
public class BasicStack<X> {
    private final X[] data;
    private int stackPointer;

    public BasicStack(int size) {
        this.data = (X[]) new Object[size];
    }

    public BasicStack() {
        this(1000);
    }

    public void push(X item) {
        data[stackPointer++] = item;
    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        X popItem = data[stackPointer];
        data[stackPointer--] = null;
        return popItem;
    }

    public boolean contains(X item) {
        boolean found = false;
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public int size() {
        return stackPointer;
    }
}
