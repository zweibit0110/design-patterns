package com.deloitte.training.oodesignpatterns.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {

    private Role role;

    private CommandExecutor executor;
    
    public CommandExecutorProxy() {
        this(Role.USER);
    }

    public CommandExecutorProxy(Role role) {
        this.role = role;
        this.executor = new CommandExecutorImpl();
    }

    @Override
    public String runCommand(String cmd) throws Exception {
        if (isAdministrator() || isSafe(cmd)) {
            return executor.runCommand(cmd);
        } else {
            throw new Exception(String.format("'%s' command is not allowed for normal users.", cmd));
        }
    }

    private boolean isAdministrator() {
        return role == Role.ADMINISTRATOR;
    }

    private boolean isSafe(String cmd) {
        String strippedCommand = removeGarbage(cmd);
        for (SafeCommand safeCommand : SafeCommand.values()) {
            if (strippedCommand.trim().contains(safeCommand.name())) {
                return true;
            }
        }

        return false;
    }

    private String removeGarbage(String cmd) {
        int index = cmd.indexOf(WINDOWS_CMD_PREFIX);
        if (index != -1) {
            return cmd.substring(index + WINDOWS_CMD_PREFIX.length());
        }
        
        return cmd;
    }
    
    private static final String WINDOWS_CMD_PREFIX = "cmd.exe /C";

}
