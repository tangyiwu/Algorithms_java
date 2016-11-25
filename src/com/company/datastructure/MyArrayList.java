package com.company.datastructure;

/**
 * Created by yixin on 2016/11/15.
 */
public class MyArrayList<E> implements MyCollection<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] EMPTY_ELEMENT_DATA = new Object[0];
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = EMPTY_ELEMENT_DATA;
    }

    private void ensureCapacity(int newSize) {
        if (newSize < DEFAULT_CAPACITY) {
            newSize = DEFAULT_CAPACITY;
        }

        if (newSize > elementData.length) {
            grow(newSize);
        }
    }

    private void grow(int newSize) {
        int oldSize = elementData.length;
        int growSize = elementData.length + elementData.length >> 1;
        if (growSize < newSize) {
            growSize = newSize;
        }
        Object[] temp = new Object[growSize];
        System.arraycopy(elementData, 0, temp, 0, oldSize);
        elementData = temp;
    }

    @Override
    public boolean add(E o) {
        ensureCapacity(size + 1);
        elementData[size++] = o;
        return true;
    }

    @Override
    public void add(int index, E o) {
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = o;
        size++;
    }

    @Override
    public void addAll(MyCollection<? extends E> collection) {
        ensureCapacity(size + collection.size());
        for (int i = 0; i < collection.size(); i++) {
            elementData[size] = collection.get(i);
            size++;
        }
    }

    @Override
    public boolean remove(E o) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == o) {
                if (i < size - 1) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                }
                elementData[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("the ArrayList size is " + size + ", index " + index + " is invalid.");
        }
        Object o = elementData[index];
        if (index < size - 1) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        }
        elementData[--size] = null;
        return (E) o;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("the ArrayList size is " + size + ", index " + index + " is invalid.");
        }
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E o) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("the ArrayList size is " + size + ", index " + index + " is invalid.");
        }
        Object old = elementData[index];
        elementData[index] = o;
        return (E) old;
    }

    @Override
    public void clear() {
        while (size > 0) {
            elementData[--size] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return super.toString() + sb.toString();
    }
}
