package com.company.pattern.singleton;

/**
 * Created by tangyiwu on 16/9/8.
 * 饿汉模式
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance() {
        return instance;
    }
}
