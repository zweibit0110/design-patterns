package com.deloitte.training.oodesignpatterns.creational.singleton;

public class BillPughSingleton {

    //
    // private inner static class as the SINGLETON HELPER/HOLDER
    //
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    private BillPughSingleton() {
    }
    
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
