package com.deloitte.training.oodesignpatterns.creational.singleton.serialization;

import java.io.Serializable;

public class WellSerializationSingleton implements Serializable {

    //
    // it implements Serializable
    //
    private static final long serialVersionUID = -7604766932017737111L;

    private WellSerializationSingleton() {
    }

    private static class SingletonHolder {
        private static final WellSerializationSingleton INSTANCE = new WellSerializationSingleton();
    }

    public static WellSerializationSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    //
    // it implements readResolve() and return the INSTANCE
    //
    private Object readResolve() {
        return getInstance();
    }

}
