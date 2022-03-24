package com.company.data;

import java.util.EmptyStackException;

public class ArrayStack<E> implements IStack<E>{

    private Object[] elements;
    private int capacity;
    private int top;

    public ArrayStack(int capacity) {
        this.elements = new Object[capacity];
        this.capacity = capacity;
        top = -1;
    }

    @Override
    public void push(E data) {
        if(isFull()) throw new ArrayIndexOutOfBoundsException("stack overflow");
        elements[++top] = data;
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        E popped = (E) elements[top];
        elements[top] = null;
        top = top - 1;
        return popped;
    }

    @Override
    public E peek() {
        if(top == -1) throw new EmptyStackException();
        return (E) elements[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (this.top + 1) == capacity;
    }
}
