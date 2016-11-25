package com.company.datastructure;

/**
 * Created by yixin on 2016/11/25.
 */
public class FixedCapacityQueueOfStrings implements Queue<String> {
    private String[] data;

    private int head = 0, tail = -1;

    private FixedCapacityQueueOfStrings() {
    }

    public FixedCapacityQueueOfStrings(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity = 0 is illegal, must capacity > 0");
        }
        data = new String[capacity];
    }

    @Override
    public boolean isEmpty() {
        return head > tail;
    }

    @Override
    public void enqueue(String s) {
        if (isEmpty()) {
            head = 0;
            tail = -1;
        }
        if (data.length == 1) {
            data[0] = s;
            tail = head = 0;
        }
        if (tail == data.length - 1 && head == 0) {
            System.arraycopy(data, 1, data, 0, tail - head);
            data[tail] = s;
        } else if (tail == data.length - 1 && head > 0) {
            System.arraycopy(data, head, data, 0, tail - head + 1);
            tail = tail - head;
            head = 0;
            data[++tail] = s;
        } else {
            data[++tail] = s;
        }
    }

    @Override
    public String dequeue() {
        if (head < data.length) {
            return data[head++];
        }
        return null;
    }
}
