package com.company.pattern.singleton;

/**
 * Created by tangyiwu on 16/9/8.
 */
public class Singleton4 {
    private Singleton4(){

    }

    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
