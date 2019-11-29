package com.deloitte.training.oodesignpatterns.structural.composite;

public abstract class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    public String getTeamMembers() {
        if (getName() != null && !getName().isEmpty()) {
            return getName().concat(" - ").concat(getRole());
        } else {
            return getRole();
        }
    }

    public abstract int getDailyRate();

    public int getTeamDailyCost() {
        return getDailyRate();
    }

}
