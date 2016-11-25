package com.company.array;

/**
 * Created by tangyiwu on 16/9/8.
 * 数组查找算法
 */
public class ArraySearch {
    /**
     * 判断二维数组中是否存在元素x
     * @param array
     * @param x
     * @return
     * eg:
     * int[][] a = new int[3][3];
    a[0][0] = 1;
    a[0][1] = 6;
    a[0][2] = 11;
    a[1][0] = 5;
    a[1][1] = 9;
    a[1][2] = 15;
    a[2][0] = 7;
    a[2][1] = 13;
    a[2][2] = 20;

    if (ArraySearch.find(a, 8)) {
    System.out.println("find 7");
    } else {
    System.out.println("not find 7");
    }
     */
    public static boolean find(int[][] array, int x) {
        if (array == null)
            return false;
        int row = 0;
        int column = array[0].length-1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == x)
                return true;
            if (array[row][column] > x) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static int findPosition(int[] array, int x) {
        int position = -1;
        for (int i=0;i<array.length;i++) {
            if (array[i] == x) {
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     * 二分查找
     * @param array 增序数组
     * @param x     查找元素
     * @return      返回下标
     * eg:
     * int [] a = {1,3,4,6,7,10,11,15,20,23,27,30,100,102,120};
     * int p1 = ArraySearch.binarySearch(a, 23);
     * int p2 = ArraySearch.binarySearch(a, 26);
     * System.out.println("p1="+p1+",p2="+p2);
     */
    public static int binarySearch(int[] array, int x) {
        if (array == null || array.length == 0)
            return -1;
        return binarySearch(array, x, 0, array.length-1);
    }

    public static int binarySearch2(int[] array, int x) {
        if (array == null || array.length == 0)
            return -1;
        return binarySearchByLooper(array, x);
    }

    /**
     * 二分查找递归算法
     * @param array
     * @param x
     * @param left
     * @param right
     * @return
     */
    private static int binarySearch(int[] array, int x, int left, int right) {
        if (left < right) {
            int m = (left + right)/2;
            if (array[m] == x) {
                return m;
            } else if (array[m] > x) {
                right = m-1;
            } else {
                left = m+1;
            }
            return binarySearch(array, x, left, right);
        } else if (left == right) {
            if (array[left] == x) {
                return left;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    private static int binarySearchByLooper(int[] array, int x) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int m = -1;
        boolean find = false;
        while (!find) {
            m = (left + right)/2;
            if (left < right) {
                if (array[m] == x) {
                    find = true;
                } else if (array[m] > x) {
                    right = m - 1;
                } else {
                    left = m + 1;
                }
            } else {
                if (array[m] == x) {
                    find = true;
                } else {
                    break;
                }
            }
        }
        if (find) {
            return m;
        } else {
            return -1;
        }
    }
}
