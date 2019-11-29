package com.deloitte.training.oodesignpatterns.creational.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton INSTANCE;

    private ThreadSafeSingleton() {
    }

    //
    // LAZY INIT + THREAD-SAFE, but WEAK PERFORMANCE (thread contention)
    //
    public static synchronized ThreadSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeSingleton();
        }
        return INSTANCE;
    }

}
