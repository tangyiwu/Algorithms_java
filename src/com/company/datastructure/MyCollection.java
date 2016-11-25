package com.company.datastructure;

/**
 * Created by yixin on 2016/11/15.
 */
public interface MyCollection<E> {
    boolean add(E e);
    void add(int index, E e);
    void addAll(MyCollection<? extends E> collection);
    boolean remove(E e);
    E remove(int index);
    int size();
    boolean isEmpty();
    boolean contains(E e);
    int indexOf(E e);
    E get(int index);
    E set(int index, E e);
    void clear();
}
