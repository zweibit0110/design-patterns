package com.deloitte.training.oodesignpatterns.structural.proxy;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import static com.deloitte.training.oodesignpatterns.structural.proxy.Role.*;

import org.junit.Test;

public class CommandExecutorTest {

    @Test
    public void executeAdminCommand() throws Exception {
        CommandExecutor executor = new CommandExecutorProxy(ADMINISTRATOR);

//        String result = executor.runCommand("cmd.exe /C echo I am the administrator");
        String result = executor.runCommand("echo I am the administrator");

        assertThat(result, containsString("echo"));
        assertThat(result, containsString("administrator"));
    }

    @Test
    public void failOnInvalidCommand() {
        CommandExecutor executor = new CommandExecutorProxy(ADMINISTRATOR);

        try {
            executor.runCommand("mycommand");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void executeSafeCommand() throws Exception {
        CommandExecutor executor = new CommandExecutorProxy(USER);

//        String result = executor.runCommand("cmd.exe /C dir");
        String result = executor.runCommand("ls");

//        assertThat(result, containsString("dir"));
        assertThat(result, containsString("ls"));
    }

    @Test
    public void executeNonSafeCommand() {
        CommandExecutor executor = new CommandExecutorProxy();

        try {
//            executor.runCommand("cmd.exe /C date /t");
            executor.runCommand("date");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
