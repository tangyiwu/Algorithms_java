package com.company.datastructure;

import com.company.util.ArrayUtil;

/**
 * Created by tangyiwu on 2016/12/9.
 * 二叉堆
 */
public class BinaryHeap {
    public void maxHeapify(int[] a, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;
        if (left <= a.length && a[left] > a[largest]) {
            largest = left;
        }
        if (right <= a.length && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            ArrayUtil.swap(a, i, largest);
            maxHeapify(a, largest);
        }
    }
}
