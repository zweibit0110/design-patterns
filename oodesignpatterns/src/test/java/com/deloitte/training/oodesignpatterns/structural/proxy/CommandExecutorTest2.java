package com.deloitte.training.oodesignpatterns.structural.proxy;

import static org.junit.Assert.*;

public class CommandExecutorTest2 {

    public void executeAdminCommnand() throws Exception {
        CommandExecutor cExecutor = new CommandExecutorProxy(Role.ADMINISTRATOR);

        String result = cExecutor.runCommand("echo I am the administrator");




    }



}