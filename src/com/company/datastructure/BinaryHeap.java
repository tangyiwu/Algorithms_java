package com.company.datastructure;

import com.company.util.ArrayUtil;

/**
 * Created by tangyiwu on 2016/12/9.
 * 二叉堆
 */
public class BinaryHeap {
    public int heapLength(int[] a) {
        return a.length - 1;
    }

    /**
     * 对最大堆的自上而下调整
     */
    public void maxHeapify(int[] a, int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;
        if (left <= heapLength(a) && a[left] > a[largest]) {
            largest = left;
        }
        if (right <= heapLength(a) && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            ArrayUtil.swap(a, i, largest);
            maxHeapify(a, largest);
        }
    }

    /**
     * 建造最大堆
     */
    public void buildMaxHeap(int[] a) {
        int i = Math.floorDiv(a.length, 2);
        while (i > 0) {
            maxHeapify(a, i);
            i--;
        }
    }
}
