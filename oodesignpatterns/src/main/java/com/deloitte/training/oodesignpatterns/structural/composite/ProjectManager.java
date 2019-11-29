package com.deloitte.training.oodesignpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManager extends Employee {

    public ProjectManager(String name) {
        super(name);
    }

    private List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public int getDailyRate() {
        return 200;
    }

    @Override
    public int getTeamDailyCost() {
        return super.getTeamDailyCost()
                + employees.
                        stream().
                        mapToInt(Employee::getTeamDailyCost).
                        sum();
    }

    @Override
    public String getTeamMembers() {
        return super.getTeamMembers().
                concat("; ").
                concat(employees.
                        stream().
                        map(Employee::getTeamMembers).
                        collect(Collectors.joining("; ")));
    }

}
