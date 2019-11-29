package com.deloitte.training.oodesignpatterns.structural.composite;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void dailyCostForOneDeveloper() {
        Employee developer = new Developer("john");
        assertThat(developer.getTeamDailyCost(), is(developer.getDailyRate()));
        assertThat(developer.getTeamMembers(), is("john - developer"));
        assertThat(developer.getRole(), is("developer"));
    }
    
    @Test
    public void dailyCostForATeam() {
        Employee john = new Developer("john");
        Employee asha = new Developer("asha");
        Employee victor = new Developer("victor");
        
        Employee zivkov = new Tester("zivkov");
        Employee mary = new Tester("mary");
        
        Employee bharat = new Analyst("bharat");
        
        ProjectManager andy = new ProjectManager("andy");
        andy.add(john);
        andy.add(asha);
        andy.add(victor);
        andy.add(zivkov);
        andy.add(mary);
        andy.add(bharat);
        
        assertThat(andy.getRole(), is("projectmanager"));
        assertThat(andy.getTeamMembers(), containsString("john - developer"));
        assertThat(andy.getTeamMembers(), containsString("mary - tester"));
        assertThat(andy.getTeamMembers(), containsString("bharat - analyst"));
        assertThat(andy.getTeamMembers(), containsString("andy - projectmanager"));
        
        int teamDailyCost = john.getDailyRate() * 3 + mary.getDailyRate() * 2 + bharat.getDailyRate() + andy.getDailyRate();
        assertThat(andy.getTeamDailyCost(), is(teamDailyCost));
    }
    
}
