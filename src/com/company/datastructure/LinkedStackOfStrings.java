package com.company.datastructure;

/**
 * Created by tangyiwu on 2016/11/22.
 */
public class LinkedStackOfStrings implements Stack<String> {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public String pop() {
        if (first == null) {
            return null;
        }
        String item = first.item;
        first = first.next;
        return item;
    }
}
