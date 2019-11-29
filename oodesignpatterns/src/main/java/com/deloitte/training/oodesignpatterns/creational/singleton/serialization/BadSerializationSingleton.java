package com.deloitte.training.oodesignpatterns.creational.singleton.serialization;

import java.io.Serializable;

public class BadSerializationSingleton implements Serializable {

    //
    // it implements Serializable only
    //
    private static final long serialVersionUID = -7604766932017737115L;

    private BadSerializationSingleton() {
    }

    private static class SingletonHolder {
        private static final BadSerializationSingleton INSTANCE = new BadSerializationSingleton();
    }

    public static BadSerializationSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
}
