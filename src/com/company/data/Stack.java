package com.company.data;

import java.util.LinkedList;

public class Stack<E> implements IStack<E>{

    LinkedList<E> list;

    public Stack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E data) {
        list.add(data);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E peek() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
