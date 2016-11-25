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
}
