package com.company.array;

import com.company.datastructure.Node;

/**
 * Created by yixin on 16/10/11.
 */
public class RecycleSkipTakeData<T> {

    private Node<T> head;

    public T[] take(T[] source, int k) {
        if (source == null || source.length == 0 || source.length == 1)
            return source;
        head = createRing(source);
        int i = 0;
        while (head.next != head) {
            Node<T> deleted = deleteNodeFromRing(head, k);
            if (deleted != null) {
                source[i] = deleted.data;
                i++;
            } else {
                break;
            }
        }
        source[i] = head.data;
        return source;
    }

    private Node<T> createRing(T[] a) {
        if (a == null || a.length == 0)
            return null;
        head = new Node<T>();
        head.data = a[0];
        Node<T> node = head;
        for (int i = 1; i < a.length; i++) {
            Node<T> temp = new Node<>();
            temp.data = a[i];
            node.next = temp;
            node = temp;
        }
        node.next = head;
        return head;
    }

    private Node<T> deleteNodeFromRing(Node<T> head, int skip) {
        if (head.next == head)
            return null;
        while (skip > 1) {
            head = head.next;
            skip--;
        }
        Node<T> target = head.next;
        head.next = target.next;
        target.next = null;
        this.head = head.next;
        return target;
    }
}
