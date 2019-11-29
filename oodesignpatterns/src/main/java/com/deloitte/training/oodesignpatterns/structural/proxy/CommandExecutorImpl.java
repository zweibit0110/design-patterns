package com.deloitte.training.oodesignpatterns.structural.proxy;

import java.io.IOException;

public class  CommandExecutorImpl implements CommandExecutor {

    @Override
    public String runCommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);

        return String.format("'%s' command executed successfully.", cmd);

    }

}
