package com.deloitte.training.oodesignpatterns.creational.singleton;

public enum EnumSingleton {
    
    // SINGLE ELEMENT ENUM
    // is the best way to implement a singleton
    // (guard against multiple instantiation by serialization or reflection)
    INSTANCE;
    
    public static void doSomething(){
        //do something
    }
    
}
