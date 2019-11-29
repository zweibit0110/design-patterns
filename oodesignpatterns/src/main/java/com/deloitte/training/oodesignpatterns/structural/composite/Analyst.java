package com.deloitte.training.oodesignpatterns.structural.composite;

public class Analyst extends Employee {

    public Analyst(String name) {
        super(name);
    }

    @Override
    public int getDailyRate() {
        return 120;
    }

}
