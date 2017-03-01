package com.company;

import com.company.array.ArraySearch;
import com.company.array.RecycleSkipTakeData;
import com.company.datastructure.*;
import com.company.util.ArrayUtil;

public class Main {

    public static void main(String[] args) {
        testBinarySearch();

        testRing();

        testMyArrayList();

        testStack();

        testQueue();

        testBinaryHeap();

        testPrivateStatic();
    }

    private static void testRing() {
        Integer[] b = {0, 1, 2, 3, 4};
        RecycleSkipTakeData<Integer> recycleSkipTakeData = new RecycleSkipTakeData<>();
        Integer[] takeArray = recycleSkipTakeData.take(b, 2);
        ArrayUtil.printArray(takeArray);
    }

    private static void testBinarySearch() {
        int[] a = {1, 3, 4, 6, 7, 10, 11, 15, 20, 23, 27, 30, 100, 102, 120};
        int p1 = ArraySearch.binarySearch2(a, 23);
        int p2 = ArraySearch.binarySearch2(a, 26);
        System.out.println("p1=" + p1 + ",p2=" + p2);
    }

    private static void testMyArrayList() {
        MyArrayList<Integer> a = new MyArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        System.out.println("\n------MyArrayList------");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + ",");
        }
        if (a.contains(3)) {
            System.out.println("\nArrayList有3");
        }
        MyArrayList<Integer> b = new MyArrayList<>();
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);
        a.addAll(b);
        System.out.println("\n");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + ",");
        }

        System.out.println("\n7 position:" + a.indexOf(7));
        a.set(4, 11);
        System.out.println(a);

        Integer int11 = Integer.valueOf(11);
        a.remove(int11);
        System.out.println(a);
        System.out.println("size is " + a.size());

        a.remove(7);
        System.out.println(a);

        a.set(4, 5);
        System.out.println(a);

        a.add(5, 6);
        System.out.println(a);

        a.clear();
        if (a.isEmpty()) {
            System.out.println("ArrayList is empty.");
        }
        System.out.println(a);
    }

    private static void testStack() {
        LinkedStackOfStrings stack1 = new LinkedStackOfStrings();
        stack1.push("1");
        stack1.push("2");
        stack1.push("3");
        stack1.push("4");
        java.lang.String item = null;
        while ((item = stack1.pop()) != null) {
            System.out.println(item);
        }

        FixedCapacityStackOfStrings stack2 = new FixedCapacityStackOfStrings(4);
        stack2.push("1");
        stack2.push("2");
        stack2.push("3");
        stack2.push("4");
        stack2.push("5");
        stack2.push("6");
        System.out.println(stack2.toString());
        while ((item = stack2.pop()) != null) {
            System.out.println(item);
        }
        System.out.println(stack2.toString());
    }

    public static void testQueue() {
        System.out.println("-------test Queue--------");
        Queue queue1 = new LinkedQueueOfStrings();
        for (int i = 0; i < 10; i++) {
            queue1.enqueue(String.valueOf(i));
        }
        while (!queue1.isEmpty()) {
            System.out.print(queue1.dequeue() + ",");
        }

        Queue queue2 = new FixedCapacityQueueOfStrings(10);
        for (int i = 0; i < 12; i++) {
            queue2.enqueue(String.valueOf(i));
        }
        System.out.println();
        while (!queue2.isEmpty()) {
            System.out.print(queue2.dequeue() + ",");
        }
    }

    public static void testBinaryHeap() {
        System.out.println();
        System.out.println("-------test binary heap-------");
        BinaryHeap heap = new BinaryHeap();
        int[] a = new int[12];
        a[1] = 11;
        a[2] = 9;
        a[3] = 10;
        a[4] = 5;
        a[5] = 6;
        a[6] = 7;
        a[7] = 8;
        a[8] = 1;
        a[9] = 2;
        a[10] = 3;
        a[11] = 4;

        // delete root node value
        a[1] = 4;
        a[11] = 0;
        heap.maxHeapify(a, 1);
        System.out.println(ArrayUtil.print(a));
        System.out.println("heap max value = " + a[1]);

        int[] b = {0, 2, 3, 1, 8, 5, 12, 7, 6, 10, 11, 4, 9, 8};
        heap.buildMaxHeap(b);
        System.out.println(ArrayUtil.print(b));
    }

    public static void testPrivateStatic() {
        for (int i = 0; i < 10; i++) {
            PrivateStaticFieldTestDemo demo = new PrivateStaticFieldTestDemo();
            demo.printDescription();
        }
    }
}
