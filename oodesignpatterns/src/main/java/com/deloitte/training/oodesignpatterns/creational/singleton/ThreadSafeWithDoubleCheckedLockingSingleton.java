package com.deloitte.training.oodesignpatterns.creational.singleton;

public class ThreadSafeWithDoubleCheckedLockingSingleton {

    private static ThreadSafeWithDoubleCheckedLockingSingleton INSTANCE;

    private ThreadSafeWithDoubleCheckedLockingSingleton() {
    }

    //
    // LAZY INIT + THREAD-SAFE, with BETTER PERFORMANCE
    //
    public static ThreadSafeWithDoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafeWithDoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }
    
}
