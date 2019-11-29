package com.deloitte.training.oodesignpatterns.creational.singleton;

public class EagerInitializedSingleton {
    
    //
    // EAGER INIT (@class loading)
    //
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();
    
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return INSTANCE;
    }
    
}
