package com.company.datastructure;

/**
 * Created by yixin on 2016/11/22.
 */
public class FixedCapacityStackOfStrings implements Stack<String> {
    private String[] s;
    private int N = 0;

    private FixedCapacityStackOfStrings() {}

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(String item) {
        s[N++] = item;
        if (N == s.length) {
            String[] temp = new String[N * 2];
            System.arraycopy(s, 0, temp, 0, N);
            s = temp;
        }
    }

    @Override
    public String pop() {
        if (N == 0) {
            return null;
        }
        String item = s[--N];
        s[N] = null;
        if (N == s.length / 4) {
            String[] temp = new String[s.length / 2];
            System.arraycopy(s, 0, temp, 0, N);
            s = temp;
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String item : s) {
            sb.append(item + ",");
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }
}
