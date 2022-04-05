package com.tictactoe.entity;

public enum Commands {

    START("start"),
    EXIT("exit");

    private final String command;
    Commands(String command) {
        this.command = command;
    }

    public String getValue() {
        return command;
    }
}
