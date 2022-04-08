package com.polis.api;

public enum TransitionCommands {
    COMMAND("COMMAND", ""),
    START_SKILL("Запусти скилл"); //todo

    private String[] command;

    TransitionCommands(String ...command) {
        this.command = command;
    }
}
