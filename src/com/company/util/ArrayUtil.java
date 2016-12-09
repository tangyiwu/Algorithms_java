package com.company.util;

/**
 * Created by tangyiwu on 16/10/12.
 */
public class ArrayUtil {
    public static <T> void printArray(T[] array) {
        if (array == null || array.length == 0)
            return;
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print("," + array[i]);
        }
    }

    public static <T> void swap(T[] a, int i, int j) {
        if (i >= 0 && i < a.length && j >= 0 && j < a.length) {
            T t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void swap(int[] a, int i, int j) {
        if (i >= 0 && i < a.length && j >= 0 && j < a.length) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static String print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(',');
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
