package com.deloitte.training.oodesignpatterns.creational.singleton;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton INSTANCE;

    private LazyInitializedSingleton() {
    }

    //
    // LAZY INIT / but NO THREAD-SAFE!
    //
    public static LazyInitializedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyInitializedSingleton();
        }
        return INSTANCE;
    }

}
