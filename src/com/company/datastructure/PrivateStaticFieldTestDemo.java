package com.company.datastructure;

/**
 * Created by tangyiwu on 2017/3/1.
 */
public class PrivateStaticFieldTestDemo {
    private static int mStaticValue;

    private static void nextStaticValue() {
        mStaticValue++;
    }

    public PrivateStaticFieldTestDemo() {
        nextStaticValue();
        System.out.println(mStaticValue);
    }

    public void printDescription() {
        System.out.println(this.toString());
    }
}
