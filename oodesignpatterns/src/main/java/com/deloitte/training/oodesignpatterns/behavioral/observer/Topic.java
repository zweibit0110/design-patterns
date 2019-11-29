package com.deloitte.training.oodesignpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {

    private List<Observer> observers = new ArrayList<>();
    
    private String message;
    
    private boolean changed;
    
    private final Object MUTEX = new Object();

    public Topic() {
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("Null Observer");
        }
        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed) {
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        
        observersLocal.stream().forEach(Observer::update);

    }

    @Override
    public Object getMessage(Observer observer) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("\nMessage Posted to Topic: " + msg);
        
        this.message = msg;
        
        this.changed = true;
        
        notifyObservers();
    }

}
