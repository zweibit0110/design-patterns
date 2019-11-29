package com.deloitte.training.oodesignpatterns.structural.composite;

public class Developer extends Employee {

    public Developer(String name) {
        super(name);
    }

    @Override
    public int getDailyRate() {
        return 100;
    }

}
