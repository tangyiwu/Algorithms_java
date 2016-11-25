package com.company.datastructure;

/**
 * Created by tangyiwu on 2016/11/25.
 */
public class LinkedQueueOfStrings implements Queue<String> {
    private Node<String> first, last;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(String s) {
        Node<String> oldLast = last;
        last = new Node<>();
        last.data = s;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (isEmpty()) {
            first = last;
        }
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<String> dNode = first;
        first = first.next;
        return dNode.data;
    }
}
