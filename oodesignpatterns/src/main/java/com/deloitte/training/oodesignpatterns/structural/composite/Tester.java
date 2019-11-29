package com.deloitte.training.oodesignpatterns.structural.composite;

public class Tester extends Employee {

    public Tester(String name) {
        super(name);
    }

    @Override
    public int getDailyRate() {
        return 80;
    }

}
