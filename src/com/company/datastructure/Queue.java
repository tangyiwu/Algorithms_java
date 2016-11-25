package com.company.datastructure;

/**
 * Created by yixin on 2016/11/25.
 */
public interface Queue<E> {
    boolean isEmpty();

    void enqueue(E e);

    E dequeue();
}
